package khrom.twitter;

import twitter4j.Status;
import twitter4j.UserStreamAdapter;

/**
 * Created by khrom on 2017/01/01.
 * apiの仕様上@文字は検索できないので使わない
 */
public class ReplyTL extends UserStreamAdapter{
    @Override
    public void onStatus(Status status) {
        super.onStatus(status);
//        System.out.println("Notification");
        System.out.println("リプライ"+status.getText());
//        if (status.getInReplyToScreenName() != null && status.getInReplyToScreenName().equals("_e1337")&&! status.getUser().getScreenName().equals("_e1337")) {
//            AutoReply.analyze(status);
//            MonitoringReply.idList.add(status);
//            MonitoringReply.idset.add(status.getId());
//        }
    }

    @Override
    public void onException(Exception e) {
        // 例外が起こった場合に通知されます
        // 今回はスタックトレースでも出しておきます
        e.printStackTrace();
    }


}
