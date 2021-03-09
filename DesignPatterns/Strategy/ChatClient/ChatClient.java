package DesignPatterns.Strategy.ChatClient;

public class ChatClient {
    private final EncryptionAlgorithm encryptionAlgorithm;

    public ChatClient(EncryptionAlgorithm encryptionAlgorithm) {
        this.encryptionAlgorithm = encryptionAlgorithm;
    }

    public String send(String message) {
        System.out.println("Sending the encrypted message...");
        return encryptionAlgorithm.encrypt(message);
    }
}
