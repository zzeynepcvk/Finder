package design_pattern.proxy;

class RealProductImage implements RealImage {
    private String filename;

    public RealProductImage(String filename) {
        this.filename = filename;
        loadImageFromDisk();
    }

    private void loadImageFromDisk() {
        // Gerçek resmin diskten yüklenmesi işlemi
        System.out.println("Loading image from disk: " + filename);
    }

    @Override
    public void display() {
        // Gerçek resmin ekrana gösterilmesi işlemi
        System.out.println("Displaying image: " + filename);
    }
}