package DesignPatterns.State.DirectionService;

public class TransitMode implements TravelMode {
    @Override
    public Object getEta() {
        System.out.println("Calculating ETA (transit)");
        return 3;
    }

    @Override
    public Object getDirection() {
        System.out.println("Calculating TravelMode (transit)");
        return 3;
    }
}
