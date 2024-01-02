package design_pattern.observer;

class User implements ProductObserver {
    private String username;

    public User(String username) {
        this.username = username;
    }

    @Override
    public void update(String productName, double discountedPrice) {
        System.out.println("Selam " + username + "! " + productName + " beklediğin ürünün fiyatı güncellendi işte yeni fiyatı : " + discountedPrice);
    }
}
