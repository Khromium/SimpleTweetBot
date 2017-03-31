package khrom.twitter;

import twitter4j.*;

/**
 * Created by khrom on 16/10/19.
 */
public class TwitterAction {

    /**
     * ふつーにツイートする
     *
     * @param message
     */
    public static void Tweet(String message) {
        try {
            TwitterFactory.getSingleton().updateStatus(message);
        } catch (TwitterException e) {
            e.printStackTrace();
        }
    }

    /**
     * ユーザに向けたreplyを送るよ
     *
     * @param user
     * @param message
     */
    public static void Reply(String user, String message) {
        try {
            TwitterFactory.getSingleton().updateStatus(user + " " + message);
        } catch (TwitterException e) {
            e.printStackTrace();
        }
    }

    /**
     * あるツイートに向けたreplyを送るよ
     *
     * @param StatusId
     * @param message
     */
    public static void Reply(long StatusId, String message) {
        StatusUpdate statusUpdate = new StatusUpdate(message);
        statusUpdate.setInReplyToStatusId(StatusId);
        try {
            TwitterFactory.getSingleton().updateStatus(statusUpdate);
        } catch (TwitterException e) {
            e.printStackTrace();
        }
    }

    /**
     * あるツイートに向けたreplyを送るよ
     *
     * @param status
     * @param message
     */
    public static void Reply(Status status, String message) {
        Reply(status.getId(), message);
    }

    /**
     * ふぁぼるよ
     *
     * @param status
     * @
     */
    public static void Favorite(Status status) {
        try {
            TwitterFactory.getSingleton().createFavorite(status.getId());
        } catch (TwitterException e) {
            e.printStackTrace();
        }
    }

    /**
     * リツイートするよ
     *
     * @param status
     * @
     */
    public static void Retweet(Status status) {
        try {
            TwitterFactory.getSingleton().retweetStatus(status.getId());
        } catch (TwitterException e) {
            e.printStackTrace();
        }
    }

    /**
     * フォローするよ
     *
     * @param id
     */
    public static void Follow(long id) {
        try {
            TwitterFactory.getSingleton().createFriendship(id);
        } catch (TwitterException e) {
            e.printStackTrace();
        }
    }

    /**
     * フォローするよ
     *
     * @param screenName
     */
    public static void Follow(String screenName) {
        try {
            TwitterFactory.getSingleton().createFriendship(screenName);
        } catch (TwitterException e) {
            e.printStackTrace();
        }

    }

    /**
     * アンフォローするよ
     *
     * @param id
     */
    public static void UnFollow(long id) {
        try {
            TwitterFactory.getSingleton().destroyFriendship(id);
        } catch (TwitterException e) {
            e.printStackTrace();
        }
    }

    /**
     * アンフォローするよ
     *
     * @param screenName
     */
    public static void UnFollow(String screenName) {
        try {
            TwitterFactory.getSingleton().destroyFriendship(screenName);
        } catch (TwitterException e) {
            e.printStackTrace();
        }
    }

    /**
     * 自分のデフォルトTimeline。常に公式RTを含む。
     * pagingしていません
     *
     * @return
     */
    public static ResponseList<Status> getHomeTimeLine() {
        try {
            return TwitterFactory.getSingleton().getHomeTimeline();
        } catch (TwitterException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 自分の発言のTL
     *
     * @return
     */
    public static ResponseList<Status> getUserTimeLine() {
        try {
            return TwitterFactory.getSingleton().getUserTimeline();
        } catch (TwitterException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 自分宛てのツイートを取得します
     * 15分当たり15回が制限
     *
     * @return
     */
    public static ResponseList<Status> getMentionsTimeLine() {
        try {
            return TwitterFactory.getSingleton().getMentionsTimeline();
        } catch (TwitterException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 自分宛てのツイートを取得します
     * 15分当たり15回が制限
     * paging対応版
     *
     * @return
     */
    public static ResponseList<Status> getMentionsTimeLine(Paging paging) {
        try {
            return TwitterFactory.getSingleton().getMentionsTimeline(paging);
        } catch (TwitterException e) {
            e.printStackTrace();
        }
        return null;
    }
}
