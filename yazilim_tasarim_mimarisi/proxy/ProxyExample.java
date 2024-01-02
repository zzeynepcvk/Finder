package design_pattern.proxy;
import java.awt.Image;
public class ProxyExample {
    public static void main(String[] args) {
        // Proxy kullanarak bir ürün resmi oluşturuluyor
        RealImage productImage = new ProxyProductImage("product123.jpg");

        // Resmi ekrana gösterme
        productImage.display();

        // Aynı resmi tekrar ekrana gösterme (bu sefer yüklenmemesi gerekir)
        productImage.display();
    }
}
