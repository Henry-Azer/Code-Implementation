package DesignPatterns.Decorator.CloudStream;

public class EncryptedCloudStream extends CloudStream {
    private final Stream stream;

    public EncryptedCloudStream(Stream stream) {
        this.stream = stream;
    }

    @Override
    public void write(String data) {
        stream.write(encrypt(data));
    }

    private String encrypt(String data) {
        return "!@#@!$#@ %#$%";
    }
}
