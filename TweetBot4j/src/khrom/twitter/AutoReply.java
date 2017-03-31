package khrom.twitter;

import twitter4j.Status;
import twitter4j.TwitterException;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by khrom on 2016/12/28.
 */
public final class AutoReply {
    private static List<String> catword = new ArrayList<>();

    private AutoReply() {
        catword = readWords("catword.txt");
    }

    /**
     * 猫返す
     *
     * @param status
     * @throws TwitterException
     */
    private static void catReply(Status status) throws TwitterException {
        Random rand = new Random();
        TwitterAction.Reply(status, "@" + status.getUser().getScreenName() +" " + catword.get(rand.nextInt(catword.size())));
    }

    /**
     * どの処理をするか分類する
     *
     * @param status
     */
    public synchronized static void analyze(Status status) {
        if (catword.size() == 0) catword = readWords("catword.txt");

        if (catword.stream().filter(status.getText()::contains).findAny().isPresent()) {
            try {
                catReply(status);
            } catch (TwitterException e) {
                e.printStackTrace();
            }
        }
    }

    private static List<String> readWords(String file_name) {
        List<String> nouns = new ArrayList<>();
        String str;
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file_name), "UTF-8"));
            while ((str = br.readLine()) != null) {
                nouns.add(str);
            }
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return nouns;
    }
}
