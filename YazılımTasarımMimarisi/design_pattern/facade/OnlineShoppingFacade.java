package design_pattern.facade;

class OnlineShoppingFacade {
    private TrendyolSubsystem trendyolSubsystem = new TrendyolSubsystem();
    private TeknosaSubsystem teknosaSubsystem = new TeknosaSubsystem();
    private HepsiburadaSubsystem hepsiburadaSubsystem = new HepsiburadaSubsystem();

    public void viewProductOnTrendyol(String productName) {
        trendyolSubsystem.goToProductPage(productName);
    }

    public void viewProductOnTeknosa(String productName) {
        teknosaSubsystem.viewProductDetails(productName);
    }

    public void viewProductOnHepsiburada(String productName) {
        hepsiburadaSubsystem.showProduct(productName);
    }
}
