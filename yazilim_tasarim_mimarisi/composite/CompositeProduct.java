package design_pattern.composite;
import java.util.ArrayList;
import java.util.List;
class CompositeProduct implements Product {
    private String name;
    private List<Product> subProducts = new ArrayList<>();

    public CompositeProduct(String name) {
        this.name = name;
    }

    public void addProduct(Product product) {
        subProducts.add(product);
    }

    @Override
    public void display() {
        System.out.println("Category: " + name);

        // Alt ürünleri ekrana yazdır
        for (Product product : subProducts) {
            product.display();
        }
    }
}