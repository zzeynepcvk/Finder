package design_pattern.proxy;

class ProxyProductImage implements RealImage {
    private RealProductImage realProductImage;
    private String filename;

    public ProxyProductImage(String filename) {
        this.filename = filename;
    }

    @Override
    public void display() {
        if (realProductImage == null) {
            // Gerçek resim yüklenmemişse, Proxy üzerinden gerçek resmi oluştur ve yükle
            realProductImage = new RealProductImage(filename);
        }
        // Gerçek resmi ekrana göster
        realProductImage.display();
    }
}
