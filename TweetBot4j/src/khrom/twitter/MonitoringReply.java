package khrom.twitter;

import twitter4j.Paging;
import twitter4j.Status;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Twitterのリプライを監視するよ
 * API制限：15分に15回
 */
public class MonitoringReply extends Thread {
    private static boolean isStop = false;
    private static final int SLEEP_TIME = 61;//一分よりわずかに大きくしている
    private static Date lastUpdate = new Date();
    public static String MY_SCREEN_NAME = "_e1337";//自分の名前

    @Override
    public void run() {
        getNewMentions(false);//初期取得用
        while (!isStop) {
            try {//一定時間のスレッド停止
                Thread.sleep(SLEEP_TIME * 1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            getNewMentions(true).forEach(this::action);
        }
    }

    public void threadStop(){
        isStop=!isStop;
        System.out.println("Stopping...");
    }

    /**
     * 新しいリプがあるか取得しあった場合はそのstatusのリストを返します
     *
     * @param isPaging ページングして取得するか
     * @return
     */
    public List<Status> getNewMentions(boolean isPaging) {
        int page = 1;
        List<Status> newMentions = new ArrayList<>();
        while (true) {
            Paging paging = new Paging(page, 800);
            List<Status> mentionsList;
            mentionsList = TwitterAction.getMentionsTimeLine(paging);
            if (mentionsList == null) break;//API制限
            //日付の新しいもののみを集める
            newMentions = mentionsList.stream().filter(s -> s.getCreatedAt().compareTo(lastUpdate) == 1 && !s.getUser().getScreenName().equals(MY_SCREEN_NAME)).collect(Collectors.toList());
            //集めた物の中で日付が最新のものに更新する。
            newMentions.forEach(s -> lastUpdate = s.getCreatedAt().compareTo(lastUpdate) == 1 ? s.getCreatedAt() : lastUpdate);
            //ページングしない場合
            if (!isPaging) break;
            //前の取得の日付までループした場合。
            if (mentionsList.stream().filter(s -> s.getCreatedAt().compareTo(lastUpdate) <= 0).findAny().isPresent())
                break;
            page++;
        }
        return newMentions;
    }

    /**
     * 新しいリプライがあった場合に飛ぶ
     */
    public void action(Status status) {
        AutoReply.analyze(status);
    }
}
