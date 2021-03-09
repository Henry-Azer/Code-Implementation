package DesignPatterns.Adapter.Image.Filters;

import DesignPatterns.Adapter.Image.Image;

public class Caramel {
    public void init() {

    }

    public void render(Image image) {
        System.out.println("Applying Caramel filter !");
    }
}
