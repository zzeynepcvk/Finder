package design_pattern.flyweight;

import java.sql.*;
import java.util.HashMap;
import java.util.Map;

class ProductFactory {
    private Map<String, Product> products = new HashMap<>();

    public Product getProduct(String name) {
        // İlgili isimde bir ürün varsa, varolan ürünü döndür
        if (products.containsKey(name)) {
            return products.get(name);
        } else {
            // Yeni bir ürün oluştur, kaydet ve döndür
            Product newProduct = createProductFromDatabase(name);
            products.put(name, newProduct);
            return newProduct;
        }
    }

    private Product createProductFromDatabase(String name) {
        // Bu kısımı gerçek veritabanı bağlantı bilgilerinizle güncellemeniz gerekiyor
        String connectionString = "jdbc:sqlserver://GAMZE_ASLAN\\SQLEXPRESS;databaseName=VTYS;integratedSecurity=true;";
        String sql = "SELECT * FROM UrunIsim WHERE Urunisim = ?";

        try (Connection connection = DriverManager.getConnection(connectionString)) {
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                preparedStatement.setString(1, name);

                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    if (resultSet.next()) {
                        double price = resultSet.getDouble("price");
                        return new ConcreteProduct(name, price);
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }
}
