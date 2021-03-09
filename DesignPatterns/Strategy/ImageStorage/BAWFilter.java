package DesignPatterns.Strategy.ImageStorage;

public class BAWFilter implements Filter {
    @Override
    public void apply(String fileName) {
        System.out.println("Apply Black and White Filter");
    }
}
