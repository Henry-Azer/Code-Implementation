package DesignPatterns.Observer.DataSource;

public class Chart implements Observer {
    private final DataSource source;

    public Chart(DataSource source) {
        this.source = source;
    }

    @Override
    public void update() {
        System.out.println("Chart got updated: " + source.getValue());
    }
}
