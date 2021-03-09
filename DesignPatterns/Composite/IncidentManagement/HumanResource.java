package DesignPatterns.Composite.IncidentManagement;

public class HumanResource extends Resource {
    @Override
    public void deploy() {
        System.out.println("Deploying a human resource");
    }
}
