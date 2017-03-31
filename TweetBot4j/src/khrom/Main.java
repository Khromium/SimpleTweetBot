package khrom;

import khrom.twitter.*;
import twitter4j.TwitterException;
import twitter4j.TwitterStream;
import twitter4j.TwitterStreamFactory;


/**
 * Created by khrom on 16/10/19.
 */
public class Main {
    public static void main(String[] args) throws TwitterException {
        OAuthTwitter.authorizeTwitter();
        TwitterStream twitterStream = TwitterStreamFactory.getSingleton();
        twitterStream.addListener(new TwitterTL());
        twitterStream.user();//自分のTLのリプ監視

        MonitoringReply monitoringReply = new MonitoringReply();
        monitoringReply.start();
//        FilterQuery filterQuery = new FilterQuery();
//        filterQuery.track(new String[]{"114514"});
//        TwitterStream twitterStream = TwitterStreamFactory.getSingleton();
//        twitterStream.addListener(new ReplyTL());
//        twitterStream.sample();
//        twitterStream.filter(filterQuery);

    }
}
