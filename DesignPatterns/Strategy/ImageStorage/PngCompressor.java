package DesignPatterns.Strategy.ImageStorage;

public class PngCompressor implements Compressor {
    @Override
    public void compress(String fileName) {
        System.out.println("PNG Compressor");
    }
}
