"""TRENDYOL - ÜRÜN İSİMLERİ"""
# Kütüphanelerin import edilmesi
from selenium import webdriver
from selenium.webdriver.common.keys import Keys
from selenium.webdriver.common.by import By
import time
import re
import pypyodbc


# Chrome tarayıcısı başlatılıyor
driver = webdriver.Chrome()
url = "https://www.trendyol.com/butik/liste/1/kadin"
driver.get(url)
time.sleep(5)

# İşlem yapılacak ürün kategorileri
urunler = ["Süpürge", "Buharlı Ütü", "Robot Süpürge", "Kahve Makinesi", "Mutfak Robotu", "Akıllı Saat",
           "Cep Telefonu", "Powerbank", "Kulaklıklar", "Fotoğraf Makinesi", "Buzdolabı", "Çamaşır Makinesi",
           "Bulaşık Makinesi", "Klima", "Bilgisayarlar", "Tablet", "Monitör", "Klavye", "Mouse", "Saç Düzleştirici",
           "Saç Maşası", "Saç Kurutma Makinesi"]

connection = pypyodbc.connect('DRIVER={ODBC Driver 17 for SQL Server};SERVER=GAMZE_ASLAN\SQLEXPRESS;DATABASE=VTYS;Trusted_Connection=yes')
cursor = connection.cursor()


# Her bir ürün kategorisi için işlem yap
for urun in urunler:
    try:
        kategori = urun
        # Search bar'a ürün ismi yazılıyor
        search_bar = driver.find_element(By.XPATH, "//*[@id='sfx-discovery-search-suggestions']/div/div[1]/input")
        search_bar.clear()
        search_bar.send_keys(urun)
        search_bar.send_keys(Keys.ENTER)
        time.sleep(5)
    
        # Toplam ürün adeti bulunuyor
        toplam_urun_adeti_str = driver.find_element(By.XPATH, "//*[@id='search-app']/div/div[1]/div[2]/div[1]/div[1]/div").text
        toplam_urun_adeti = int(re.findall(r'\b[0-9]+\b', toplam_urun_adeti_str)[0])
        if ( toplam_urun_adeti==100 or toplam_urun_adeti > 1000):toplam_urun_adeti = 1000

    
        # Ürün bilgileri çekiliyor ve MSSQL veritabanına ekleniyor
        for i in range(0, toplam_urun_adeti):
            try :
                urun_ust_bilgileri=driver.find_elements(By.CLASS_NAME,"p-card-wrppr with-campaign-view")
                urun_bilgileri = driver.find_elements(By.CSS_SELECTOR, 'h3.prdct-desc-cntnr-ttl-w.two-line-text')
                urun_marka = urun_bilgileri[i].find_elements(By.CSS_SELECTOR, "span")[0].text
                urun_isim = urun_bilgileri[i].find_elements(By.CSS_SELECTOR, "span")[1].text
                urun_tam_isim = urun_marka +" " + urun_isim
                j=i+1
                path = '//*[@id="search-app"]/div/div[1]/div[2]/div[4]/div[1]/div/div['+str(j)+']/div[1]/a/div[1]/div[1]/img'
                urun_resim_url = driver.find_element(By.XPATH,path).get_attribute("src")
                query = "INSERT INTO Urunisim (UrunIsim, UrunResimUrl) VALUES (?, ?)"
                cursor.execute(query,(urun_tam_isim, urun_resim_url))
         
                # Her ürün okunduktan sonra sayfayı aşağı kaydır
                if (i % 3 == 0):
                    action = webdriver.ActionChains(driver)
                    action.key_down(Keys.SPACE).key_up(Keys.SPACE).perform()
                    time.sleep(2)
            except Exception:
                continue
                
    except Exception:
        continue 
connection.commit()
connection.close()
