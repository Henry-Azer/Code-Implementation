package DesignPatterns.Composite.IncidentManagement;

public class Truck extends Resource {
    @Override
    public void deploy() {
        System.out.println("Deploying a truck");
    }
}
