package Executors;

public class Quote {
    private final String Site;
    private final int price;

    public Quote(String site, int price) {
        Site = site;
        this.price = price;
    }

    public String getSite() {
        return Site;
    }

    public int getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Quote{" +
                "Site='" + Site + '\'' +
                ", price=" + price +
                '}';
    }
}
