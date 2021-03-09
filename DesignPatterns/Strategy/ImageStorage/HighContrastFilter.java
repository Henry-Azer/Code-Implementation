package DesignPatterns.Strategy.ImageStorage;

public class HighContrastFilter implements Filter {
    @Override
    public void apply(String fileName) {
        System.out.println("Apply High Contrast Filter");
    }
}
