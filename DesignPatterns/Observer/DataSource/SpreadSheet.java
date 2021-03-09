package DesignPatterns.Observer.DataSource;

public class SpreadSheet implements Observer{
    private final DataSource source;

    public SpreadSheet(DataSource source) {
        this.source = source;
    }

    @Override
    public void update() {

        System.out.println("SpreadSheet got notified: " + source.getValue());
    }
}
