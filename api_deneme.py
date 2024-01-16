from flask import Flask, request, jsonify, render_template
import pypyodbc
from flask_cors import CORS

app = Flask(__name__)
CORS(app)

# Veritabanı bağlantısı
connection = pypyodbc.connect('DRIVER={ODBC Driver 17 for SQL Server};SERVER=GAMZE_ASLAN\SQLEXPRESS;DATABASE=VTYS;Trusted_Connection=yes')
cursor = connection.cursor()

@app.route('/')
def index():
    return render_template('product.html')


@app.route('/get_product_info', methods=['POST'])
def get_product_info():
    try:
        # İstekten gelen JSON verisini al
        data = request.get_json()

        # Ürün ismini al
        product_name = data.get('product_name')

        # Ürün ismini kullanarak UrunIsim tablosundan id değerini bul
        cursor.execute("SELECT UrunID FROM Urunisim WHERE UrunIsim = ?", (product_name,))
        product_id = cursor.fetchone()

        if product_id:
            # Eğer ürün bulunduysa, bu id ile UrunFiyat tablosundan ilgili ürünleri getir
            cursor.execute("SELECT * FROM UrunFiyat WHERE UrunID = ?", (product_id[0],))
            product_prices = cursor.fetchall()

            # Ürün fiyatlarını JSON olarak döndür
            return jsonify({"product_prices": product_prices})
        else:
            # Eğer ürün bulunamadıysa hata mesajı döndür
            return jsonify({"error": "Ürün bulunamadı"}), 404

    except Exception as e:
        # Hata durumunda hata mesajını döndür
        return jsonify({"error": str(e)}), 500


if __name__ == '__main__':
    # Uygulamayı çalıştır
    app.run(debug=True, port=5000)
