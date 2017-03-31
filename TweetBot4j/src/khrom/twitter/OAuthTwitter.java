package khrom.twitter;

import twitter4j.Twitter;
import twitter4j.TwitterFactory;
import twitter4j.TwitterStream;
import twitter4j.TwitterStreamFactory;
import twitter4j.auth.AccessToken;

/**
 * トークン管理用
 */
public class OAuthTwitter {
    /**
     * _e1337の方
     * にゃんにゃん
     */
    private static final String CONSUMER_KEY = "";
    private static final String CONSUMER_SECRET = "";
    private static final String ACCESS_TOKEN = "";
    private static final String ACCESS_SECRET = "";

    public static void authorizeTwitter() {
        Twitter tw = TwitterFactory.getSingleton();
        tw.setOAuthConsumer(CONSUMER_KEY, CONSUMER_SECRET);
        tw.setOAuthAccessToken(new AccessToken(ACCESS_TOKEN, ACCESS_SECRET));

        TwitterStream twt = TwitterStreamFactory.getSingleton();
        twt.setOAuthConsumer(CONSUMER_KEY, CONSUMER_SECRET);
        twt.setOAuthAccessToken(new AccessToken(ACCESS_TOKEN, ACCESS_SECRET));

    }
}
