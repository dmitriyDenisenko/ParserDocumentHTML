import org.jsoup.Jsoup;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void extractURL(
            String str)
    {

        List<String> list
                = new ArrayList<>();

        String regex
                = "\\b((?:https?|ftp|file):"
                + "//[-a-zA-Z0-9+&@#/%?="
                + "~_|!:, .;]*[-a-zA-Z0-9+"
                + "&@#/%=~_|])";

        Pattern p = Pattern.compile(
                regex,
                Pattern.CASE_INSENSITIVE);

        Matcher m = p.matcher(str);

        while (m.find()) {
            list.add(str.substring(
                    m.start(0), m.end(0)));
        }

        if (list.size() == 0) {
            System.out.println("-1");
            return;
        }

        for (String url : list) {
            System.out.println(url);
        }
    }
    public static void main(String[] args){
        try{
            var document = Jsoup.connect("https://ru.wikipedia.org/wiki/Заглавная_страница").get();
            var titleElement = document.getAllElements();
            extractURL(titleElement.text());
        } catch (Exception e){
            e.printStackTrace();
        }


    }
}
