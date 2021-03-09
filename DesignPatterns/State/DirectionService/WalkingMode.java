package DesignPatterns.State.DirectionService;

public class WalkingMode implements TravelMode {
    @Override
    public Object getEta() {
        System.out.println("Calculating ETA (walking)");
        return 4;
    }

    @Override
    public Object getDirection() {
        System.out.println("Calculating TravelMode (walking)");
        return 4;
    }
}
