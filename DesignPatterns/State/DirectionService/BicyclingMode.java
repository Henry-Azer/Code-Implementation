package DesignPatterns.State.DirectionService;

public class BicyclingMode implements TravelMode {
    @Override
    public Object getEta() {
        System.out.println("Calculating ETA (bicycling)");
        return 2;
    }

    @Override
    public Object getDirection() {
        System.out.println("Calculating TravelMode (bicycling)");
        return 2;
    }
}
