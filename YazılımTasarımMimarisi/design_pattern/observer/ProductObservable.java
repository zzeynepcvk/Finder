package design_pattern.observer;

interface ProductObservable {
    void addObserver(ProductObserver observer);
    void removeObserver(ProductObserver observer);
    void notifyObservers();
}
