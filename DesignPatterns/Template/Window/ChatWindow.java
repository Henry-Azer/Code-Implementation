package DesignPatterns.Template.Window;

public class ChatWindow extends Window {
    @Override
    protected void onClosing() {
        System.out.println("Closing.");
    }

    @Override
    protected void onClosed() {
        System.out.println("Disconnecting from the server...");
    }
}
