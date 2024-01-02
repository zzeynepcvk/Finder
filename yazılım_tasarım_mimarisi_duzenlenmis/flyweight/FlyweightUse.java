package design_pattern.flyweight;

public class FlyweightUse {
    public static void main(String[] args) {
        ProductFactory productFactory = new ProductFactory();

        // Ürünlerin nesnelerini oluşturma -- zaman kaybetmemek için buranın tamamını uygulamadık
        Product product1 = productFactory.getProduct("A");
        Product product2 = productFactory.getProduct("B");




    }
}
