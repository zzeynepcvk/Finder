package design_pattern.flyweight;

public class FlyweightExample {
    public static void main(String[] args) {
        ProductFactory productFactory = new ProductFactory();

        // İki farklı ürün için Flyweight nesneleri oluşturuluyor
        Product product1 = productFactory.getProduct("A");
        Product product2 = productFactory.getProduct("B");

        // Aynı ürün için bir kez daha nesne oluşturuluyor, ancak bu sefer varolan nesne kullanılıyor
        Product product3 = productFactory.getProduct("A");

        // Ürünleri ekrana yazdırma
        product1.display();  // Output: Product: A
        product2.display();  // Output: Product: B
        product3.display();  // Output: Product: A (varolan nesne kullanılıyor)
    }
}
