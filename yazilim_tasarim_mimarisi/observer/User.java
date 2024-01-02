package design_pattern.observer;

class User implements ProductObserver {
    private String username;

    public User(String username) {
        this.username = username;
    }

    @Override
    public void update(String productName, double discountedPrice) {
        System.out.println("Hey " + username + "! " + productName + " is now on sale. New price: " + discountedPrice);
    }
}
