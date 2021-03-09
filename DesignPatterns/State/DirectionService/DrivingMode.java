package DesignPatterns.State.DirectionService;

public class DrivingMode implements TravelMode {
    @Override
    public Object getEta() {
        System.out.println("Calculating ETA (driving)");
        return 1;
    }

    @Override
    public Object getDirection() {
        System.out.println("Calculating TravelMode (driving)");
        return 1;
    }
}
