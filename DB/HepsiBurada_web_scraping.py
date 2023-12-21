#HEPSÄ°BURADA-BS4 

import requests
from bs4 import BeautifulSoup
import Levenshtein
import pypyodbc

connection = pypyodbc.connect('DRIVER={ODBC Driver 17 for SQL Server};SERVER=GAMZE_ASLAN\SQLEXPRESS;DATABASE=VTYS;Trusted_Connection=yes')
cursor = connection.cursor()

def calculate_similarity(text1, text2):
    return Levenshtein.ratio(text1, text2)

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
    

def turkce_kelime_cevirici(urun_isim):
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
            sorgu = sorgu+yeni_isim_listesi[i]+"+"
        else:
            sorgu=sorgu+yeni_isim_listesi[i]
    return sorgu

def url_olustur(sorgu_url):
    url = "https://www.hepsiburada.com/ara?q="+sorgu_url
    return url


urunler = cursor.execute("SELECT * FROM Urunisim")
urunler = cursor.fetchall()
urunler=urunler[:10]

for urun in urunler :
    try :
        urunid=urun[0]
        urun = urun[1]
        urun_url = url_olustur(sorgu_url_olusturma(turkce_kelime_cevirici(urun)))
        headers={"User-Agent":"Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/120.0.0.0 Safari/537.36"}
        html = requests.get(urun_url,headers=headers).content
        soup=BeautifulSoup(html,"html.parser")
        urun_li = soup.find_all("li",{"class":"productListContent-zAP0Y5msy8OHn5z7T_K_"})
        urun_adet = len(urun_li)
        if(urun_adet>5):urun_adet=5
        benzerlik_oranlari=[]
        for adet in urun_li:
            urun_isim = adet.find("h3",{"data-test-id":"product-card-name"}).text
            urun_fiyat = adet.find("div",{"data-test-id":"price-current-price"}).text
            urun_url = "https://www.hepsiburada.com"+adet.find("a").get("href")
            fiyat_str = urun_fiyat.replace('.', '').replace(',', '').replace('TL', '').strip()
            fiyat_float = float(fiyat_str)
            similarity_ratio = calculate_similarity(urun, urun_isim)
            benzerlik_oranlari.append([similarity_ratio,urun_isim,fiyat_float,urun_url])
            
        degerler = find_max_bruteforce(benzerlik_oranlari)
        siteid=3
        urun_isim = degerler[1]
        urun_fiyat = degerler[2]
        urun_url = degerler[3] 
        query = "INSERT INTO UrunFiyat (UrunID,SiteID,UrunIsim, UrunURL,UrunFiyat) VALUES (?, ?, ?, ?, ?)"
        cursor.execute(query,(urunid,siteid,urun_isim, urun_url,urun_fiyat))
        
    except Exception:
       continue
   
connection.commit()
connection.close()
