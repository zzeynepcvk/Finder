package design_pattern.facade;

public class OnlineShoppingExample {
    public static void main(String[] args) {
        // Facade kullanarak ürünü farklı sitelerde görüntüleme
        OnlineShoppingFacade shoppingFacade = new OnlineShoppingFacade();
        shoppingFacade.viewProductOnTrendyol("Example Product");
        shoppingFacade.viewProductOnTeknosa("Example Product");
        shoppingFacade.viewProductOnHepsiburada("Example Product");
    }
}
