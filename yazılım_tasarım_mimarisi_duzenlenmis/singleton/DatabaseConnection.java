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
            // MSSQL veritabanı bağlantısı oluşturuluyor
            // TODO: Gerçek uygulamada bağlantı bilgileri daha güvenli bir şekilde saklanmalıdır.
            String connectionString = "jdbc:sqlserver://GAMZE_ASLAN\\SQLEXPRESS;databaseName=VTYS;integratedSecurity=true;";
            connection = DriverManager.getConnection(connectionString);
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