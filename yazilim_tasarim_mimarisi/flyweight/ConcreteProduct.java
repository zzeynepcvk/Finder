package design_pattern.flyweight;

class ConcreteProduct implements Product {
    private String name;

    public ConcreteProduct(String name) {
        this.name = name;
    }

    @Override
    public void display() {
        System.out.println("Product: " + name);
    }
}
