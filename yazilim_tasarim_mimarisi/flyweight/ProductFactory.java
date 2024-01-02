package design_pattern.flyweight;

import java.util.HashMap;
import java.util.Map;

// Flyweight Fabrika Sınıfı
class ProductFactory {
    private Map<String, Product> products = new HashMap<>();

    public Product getProduct(String name) {
        // İlgili isimde bir ürün varsa, varolan ürünü döndür
        if (products.containsKey(name)) {
            return products.get(name);
        } else {
            // Yeni bir ürün oluştur, kaydet ve döndür
            Product newProduct = new ConcreteProduct(name);
            products.put(name, newProduct);
            return newProduct;
        }
    }
}