package design_pattern.singleton;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
class ProductRepository {
    private DatabaseConnection databaseConnection;

    public ProductRepository() {
        // Singleton veritabanı bağlantısı alınıyor
        databaseConnection = DatabaseConnection.getInstance();
    }

    public Product getProductById(int productId) {
        try {
            Connection connection = databaseConnection.getConnection();
            Statement statement = connection.createStatement();

            // SQL sorgusu ile belirtilen ID'ye sahip ürün bilgisi çekiliyor
            ResultSet resultSet = statement.executeQuery("SELECT * FROM products WHERE id = " + productId);

            if (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                return new Product(id, name); // Veritabanından alınan bilgilerle Product nesnesi oluşturuluyor
            }

        } catch (SQLException e) {
            e.printStackTrace(); // Hata durumunda consola hata mesajı yazdırılıyor
        }

        return null; // Ürün bulunamazsa null döndürülüyor
    }
}
