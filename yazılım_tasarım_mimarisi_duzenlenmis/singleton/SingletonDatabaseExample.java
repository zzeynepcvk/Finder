package design_pattern.singleton;

public class SingletonDatabaseExample {
    public static void main(String[] args) {
        // Singleton veritabanı bağlantısı alınıyor
        DatabaseConnection dbConnection = DatabaseConnection.getInstance();

        // Ürün veritabanı erişim sınıfı oluşturuluyor
        ProductRepository productRepository = new ProductRepository();

        // Ürün ID'si belirleniyor
        int productId = 1;

        // Ürün bilgisi çekiliyor
        Product product = productRepository.getProductById(productId);

        // Ürün bilgisi ekrana yazdırılıyor
        if (product != null) {
            System.out.println("Product ID: " + product.getId());
            System.out.println("Product Name: " + product.getName());
        } else {
            System.out.println("Product not found.");
        }
    }
}
