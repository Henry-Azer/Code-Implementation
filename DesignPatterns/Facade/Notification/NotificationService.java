package DesignPatterns.Facade.Notification;

public class NotificationService {
    public void send(String message, String target) {
        var server = new NotificationServer();
        var conn = server.connect("ip");
        var auth = server.authenticate("appID", "key");
        server.send(auth, new Message(message), target);
        conn.disconnect();
    }
}
