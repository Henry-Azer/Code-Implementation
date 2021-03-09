package DesignPatterns.Facade.Twitter;

import java.util.List;

public class TwitterAPI {
    private final String appKey;
    private final String secret;

    public TwitterAPI(String appKey, String secret) {
        this.appKey = appKey;
        this.secret = secret;
    }

    public List<Tweet> getRecentTweets() {
        var twitterClient = new TwitterClient();
        return twitterClient.getRecentTweets(getAccessToken());
    }

    private String getAccessToken() {
        var oauth = new OAuth();
        var requestToken = oauth.requestToken("appKey", "secret");
        return oauth.getAccessToken(requestToken);
    }
}
