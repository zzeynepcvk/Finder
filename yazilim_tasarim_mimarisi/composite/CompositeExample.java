package design_pattern.composite;


public class CompositeExample {
    public static void main(String[] args) {
        // Elektronik kategorisi oluşturuluyor
        CompositeProduct electronics = new CompositeProduct("Electronics");

        // Telefon kategorisi oluşturuluyor
        CompositeProduct phones = new CompositeProduct("Phones");

        // Alt kategorileri oluşturuluyor
        ConcreteProduct smartphone = new ConcreteProduct("Smartphone");
        ConcreteProduct androidPhone = new ConcreteProduct("Android Phone");
        ConcreteProduct iphone = new ConcreteProduct("iPhone");

        // Alt kategoriler telefon kategorisine ekleniyor
        phones.addProduct(smartphone);
        phones.addProduct(androidPhone);
        phones.addProduct(iphone);

        // Diğer alt kategoriler oluşturuluyor
        ConcreteProduct powerbank = new ConcreteProduct("Powerbank");
        ConcreteProduct wearableTech = new ConcreteProduct("Wearable Technology");

        // Elektronik kategorisine alt kategoriler ekleniyor
        electronics.addProduct(phones);
        electronics.addProduct(powerbank);
        electronics.addProduct(wearableTech);

        // Elektronik kategorisinin içeriğini göster
        electronics.display();
    }
}