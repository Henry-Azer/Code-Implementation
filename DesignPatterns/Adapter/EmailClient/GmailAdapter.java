package DesignPatterns.Adapter.EmailClient;

import DesignPatterns.Adapter.EmailClient.Gmail.GmailClient;

public class GmailAdapter extends GmailClient implements EmailProvider {
    @Override
    public void downloadEmails() {
        connect();
        getEmails();
        disconnect();
    }
}
