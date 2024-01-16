from elasticsearch import Elasticsearch
import pypyodbc

# Elasticsearch bağlantısını kurun
es = Elasticsearch(['http://localhost:9200'])

# Elasticsearch indeksi adı
index_name = "test2"

# Veritabanı bağlantısı
conn = pypyodbc.connect('DRIVER={ODBC Driver 17 for SQL Server};SERVER=GAMZE_ASLAN\SQLEXPRESS;DATABASE=VTYS;Trusted_Connection=yes')
cursor = conn.cursor()
cursor.execute("SELECT UrunIsim FROM Urunisim")
rows = cursor.fetchall()
product_names = [i[0] for i in rows]

# Her bir ürün ismi için Elasticsearch'e belge ekle
for product_name in product_names:
    # Elasticsearch'e belgeyi ekle
    es.index(index=index_name, body={"title": product_name})

# Veritabanı bağlantısını kapat
conn.close()
