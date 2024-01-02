package design_pattern.observer;
import java.util.ArrayList;
import java.util.List;
class Product implements ProductObservable {
    private String productName;
    private double price;
    private List<ProductObserver> observers = new ArrayList<>();

    public Product(String productName, double price) {
        this.productName = productName;
        this.price = price;
    }

    public void setDiscountedPrice(double discountedPrice) {
        // İndirim fiyatı güncellendiğinde bildirim yapılır
        if (discountedPrice < price) {
            price = discountedPrice;
            notifyObservers();
        }
    }

    @Override
    public void addObserver(ProductObserver observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(ProductObserver observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (ProductObserver observer : observers) {
            observer.update(productName, price);
        }
    }
}