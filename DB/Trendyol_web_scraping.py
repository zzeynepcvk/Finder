"""TRENDYOL FÄ°YAT - BS4"""
import requests
from bs4 import BeautifulSoup
import Levenshtein
import pypyodbc
from datetime import datetime


connection = pypyodbc.connect('DRIVER={ODBC Driver 17 for SQL Server};SERVER=GAMZE_ASLAN\SQLEXPRESS;DATABASE=VTYS;Trusted_Connection=yes')
cursor = connection.cursor()

print("Başlangıç : {0}".format(datetime.now()))
def karakter_sayisini_azalt(urun): 
    kelime_son=''
    toplam=0
    kelime_list=urun.split(' ')
    for kelime in kelime_list:
        toplam=toplam+len(kelime)+1
        if(toplam<=50):
            kelime_son=kelime_son+' '+kelime
            kelime=kelime.strip()
    return kelime_son


def find_max_bruteforce(arr):
    max_benzerlik_orani = arr[0][0]
    for num in arr:
        if num[0] >= max_benzerlik_orani:
            max_benzerlik_orani = num[0]
            urun_isim=num[1]
            urun_fiyat=num[2]
            urun_url=num[3]            
    if max_benzerlik_orani>=0.7:
        return [max_benzerlik_orani,urun_isim,urun_fiyat,urun_url]
    else :
        pass
    
#metin benzerlik oranlarÃÂ±nÃÂ± hesapla :
def calculate_similarity(text1, text2):
    return Levenshtein.ratio(text1, text2)


    

def turkce_kelime_cevirici(urun_isim):
    urun_isim = karakter_sayisini_azalt(urun_isim)
    turkce_kelime_list=['Ç', 'Ğ', 'İ', 'Ö', 'Ş', 'Ü', 'ç', 'ğ', 'ı', 'ö', 'ş', 'ü']
    yeni_isim_listesi=[]
    urun_liste=urun_isim.split(" ")
    for kelime in urun_liste:
        yeni_kelime=""
        for harf in kelime :
            if (harf in turkce_kelime_list):
                dondur = "%C3%BC"
            else :
                dondur = harf
            yeni_kelime = yeni_kelime+dondur
        yeni_isim_listesi.append(yeni_kelime)
    return yeni_isim_listesi
        
def sorgu_url_olusturma(yeni_isim_listesi):
    sorgu=""
    for i in range(len(yeni_isim_listesi)):
        if(i!=(len(yeni_isim_listesi)-1)):
            sorgu = sorgu+yeni_isim_listesi[i]+"%20"
        else:
            sorgu=sorgu+yeni_isim_listesi[i]
    return sorgu

def url_olustur(sorgu_url):
    url = "https://www.trendyol.com/sr?q="+sorgu_url+"&qt="+sorgu_url+"&st="+sorgu_url+"&os=1"
    return url




urunler = cursor.execute("SELECT * FROM Urunisim")
urunler = cursor.fetchall()


    
for urun in urunler :
    try:
        urunid=urun[0]
        urun = urun[1]
        urun_url = url_olustur(sorgu_url_olusturma(turkce_kelime_cevirici(urun)))
        headers={"User-Agent":"Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/120.0.0.0 Safari/537.36"}
        html = requests.get(urun_url,headers=headers).content
        soup=BeautifulSoup(html,"html.parser")
        urunler = soup.find_all("div",{"class":"p-card-wrppr with-campaign-view"})
        urun_adet = len(urunler)
        if(urun_adet>5):urun_adet=5
        benzerlik_oranlari=[]
        if(urun_adet>1):
            for i in range(urun_adet-1):
                urun_marka=urunler[i].find("span",{"class":"prdct-desc-cntnr-ttl"}).text
                urun_isim=urunler[i].find("span",{"class":"prdct-desc-cntnr-name hasRatings"}).text
                urun_tam_isim =urun_marka +" " + urun_isim 
                urun_fiyat = urunler[i].find("div",{"class":"prc-box-dscntd"}).text
                urun_url = urunler[i].find("a").get("href")
                fiyat_str = urun_fiyat.replace('.', '').replace(',', '').replace('TL', '').strip()
                fiyat_float = float(fiyat_str)
                similarity_ratio = calculate_similarity(urun, urun_isim)
                benzerlik_oranlari.append([similarity_ratio,urun_tam_isim,fiyat_float,urun_url])

        elif(urun_adet==1):
            urun_marka = soup.find("div",{"class":"p-card-wrppr with-campaign-view"}).find("span",{"class":"prdct-desc-cntnr-ttl"}).text
            urun_isim = soup.find("div",{"class":"p-card-wrppr with-campaign-view"}).find("span",{"class":"prdct-desc-cntnr-name hasRatings"}).text
            urun_tam_isim =urun_marka +" " + urun_isim 
            urun_fiyat =soup.find("div",{"class":"p-card-wrppr with-campaign-view"}).find("div",{"class":"prc-box-dscntd"}).text
            urun_url = soup.find("div",{"class":"p-card-wrppr with-campaign-view"}).find("a").get("href")
            similarity_ratio = calculate_similarity(urun, urun_isim)
            benzerlik_oranlari.append([similarity_ratio,urun_tam_isim,fiyat_float,urun_url])
                                            
        degerler = find_max_bruteforce(benzerlik_oranlari)
        siteid=1
        urun_isim = degerler[1]
        urun_fiyat = degerler[2]
        urun_url = degerler[3] 
        query = "INSERT INTO Urun_Fiyat (UrunID,SiteID,UrunIsim, UrunURL,UrunFiyat) VALUES (?, ?, ?, ?, ?)"
        cursor.execute(query,(urunid,siteid,urun_isim, urun_url,urun_fiyat))
   
    
    except Exception:
        continue

    
connection.commit()
connection.close()

print("Bitiş : {0}".format(datetime.now()))
