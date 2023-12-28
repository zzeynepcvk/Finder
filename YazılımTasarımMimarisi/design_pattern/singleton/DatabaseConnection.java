package design_pattern.singleton;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

// Singleton Veritabanı Bağlantısı
class DatabaseConnection {
    private static DatabaseConnection instance; // Singleton örneği
    private Connection connection; // Veritabanı bağlantısı

    private DatabaseConnection() {
        try {
            // Veritabanı bağlantısı oluşturuluyor (örnek amaçlı basitleştirilmiştir)
            // TODO: Gerçek uygulamada bağlantı bilgileri daha güvenli bir şekilde saklanmalıdır.
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydatabase", "username", "password");
        } catch (SQLException e) {
            e.printStackTrace(); // Hata durumunda consola hata mesajı yazdırılıyor
        }
    }

    public static DatabaseConnection getInstance() {
        if (instance == null) {
            instance = new DatabaseConnection(); // İlk çağrıda Singleton örneği oluşturuluyor
        }
        return instance; // Singleton örneği döndürülüyor
    }

    public Connection getConnection() {
        return connection; // Veritabanı bağlantısı döndürülüyor
    }
}

