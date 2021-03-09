package DesignPatterns.Decorator.CloudStream;

public class CompressedCloudStream implements Stream {
    private final Stream stream;

    public CompressedCloudStream(Stream stream) {
        this.stream = stream;
    }

    @Override
    public void write(String data) {
        stream.write(compress(data));
    }

    private String compress(String data) {
        return data.substring(0, 5);
    }
}
