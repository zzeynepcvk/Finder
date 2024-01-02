package design_pattern.proxy;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class RealProductImage implements RealImage {
    private final String filename;
    private String imageUrl;

    public RealProductImage(String filename) {
        this.filename = filename;
        loadImageFromDatabase();
    }

    private void loadImageFromDatabase() {
        // Bu kısmı SQL sorgusu ile değiştirelim
        String connectionString = "DRIVER={ODBC Driver 17 for SQL Server};SERVER=GAMZE_ASLAN\\SQLEXPRESS;DATABASE=VTYS;Trusted_Connection=yes";
        String sql = "SELECT UrunResimUrl FROM UrunIsim WHERE UrunDosyaAdi = ?";

        try (Connection connection = DriverManager.getConnection(connectionString)) {
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                preparedStatement.setString(1, filename);

                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    if (resultSet.next()) {
                        // Veritabanından UrunResimUrl bilgisini al
                        imageUrl = resultSet.getString("UrunResimUrl");
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        // Image yüklemesi burada yapılır. Bu sadece bir örnek ve gerçek uygulamada uygun bir şekilde yüklenmesi gerekmektedir.
        System.out.println("Loading image from: " + imageUrl);
    }

    @Override
    public void display() {
        System.out.println("Displaying image: " + filename);
        // Gerçek resmin ekrana gösterilmesi işlemi
    }
}
