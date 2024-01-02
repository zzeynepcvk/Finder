package design_pattern.observer;


/*Tasarım kalıbının denenmesi*/
public class ObserverExample {
    public static void main(String[] args) {
        // Ürün ve kullanıcı örnekleri oluşturuluyor
        Product phone = new Product("Smartphone", 1000);
        User user1 = new User("User1");
        User user2 = new User("User2");

        // Kullanıcılar, ürünü izleyenlere ekleniyor
        phone.addObserver(user1);
        phone.addObserver(user2);

        // Ürün indirime girdiğinde bildirim yapılır
        phone.setDiscountedPrice(800);
    }
}