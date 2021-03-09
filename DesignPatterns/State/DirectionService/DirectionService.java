package DesignPatterns.State.DirectionService;

public class DirectionService {
    private TravelMode currentTravelMode;

    public Object getEta() {
        return currentTravelMode.getEta();
    }

    public Object getDirection() {
        return currentTravelMode.getDirection();
    }

    public void setCurrentTravelMode(TravelMode travelMode) {
        this.currentTravelMode = travelMode;
    }
}
