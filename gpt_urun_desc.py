import pypyodbc
import openai
from my_api_key import API_KEY

obj = API_KEY()

openai.api_key = obj.api_key


conn = pypyodbc.connect('DRIVER={ODBC Driver 17 for SQL Server};SERVER=GAMZE_ASLAN\SQLEXPRESS;DATABASE=VTYS;Trusted_Connection=yes')
cursor = conn.cursor()


urunler = cursor.execute("SELECT * FROM Urunisim")
urun_isimleri = cursor.fetchall()

for urun_adi in urun_isimleri:
    urun_adi = urun_adi[0]  # Tuple'dan çıkartma
    prompt = f"Bu ürünü açıklayın: {urun_adi}."
    
    # GPT-3'ten metin üret
    response = openai.Completion.create(
        engine="text-davinci-003",  # Güncel bir model adı kullanın
        prompt=prompt,
        max_tokens=150
    )

    
    urun_aciklamasi = response.choices[0].text.strip()
    cursor.execute('INSERT INTO urun_aciklamalari (urun_adi, aciklama) VALUES (?, ?)',
                   (urun_adi, urun_aciklamasi))
    conn.commit()

# Veritabanı bağlantısını kapat
conn.close()