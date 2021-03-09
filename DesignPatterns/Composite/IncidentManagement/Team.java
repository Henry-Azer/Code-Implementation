package DesignPatterns.Composite.IncidentManagement;

import java.util.ArrayList;
import java.util.List;

public class Team extends Resource {
    private final List<Resource> resources = new ArrayList<>();

    public void add(Resource resource) {
      resources.add(resource);
    }

    @Override
    public void deploy() {
        for (var resource : resources)
            resource.deploy();
    }
}
