package khrom.twitter;

import twitter4j.*;



/**
 * TLよう
 * http://twitter4j.org/javadoc/twitter4j/UserStreamAdapter.html
 */
public class TwitterTL extends UserStreamAdapter {


    /**
     * TL
     *
     * @param status
     */
    @Override
    public void onStatus(Status status) {
        super.onStatus(status);
        System.out.println(status.getText());
//        if (status.getInReplyToScreenName() != null && status.getInReplyToScreenName().equals(MY_SCREEN_NAME)&&! status.getUser().getScreenName().equals(MY_SCREEN_NAME)) {
//            AutoReply.analyze(status);
//        }//実際高速にリプ返す必要もない。
    }

    @Override
    public void onException(Exception e) {
        e.printStackTrace();
    }


}
