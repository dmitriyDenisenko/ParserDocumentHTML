import org.jsoup.Jsoup;

public class Main {

    public static void main(String[] args){
        try{
            var document = Jsoup.connect("https://ru.wikipedia.org/wiki/Заглавная_страница").get();
            var titleElement = document.select("a");
            for(var element : titleElement){
                System.out.println(element.attr("href"));
            }
        } catch (Exception e){
            e.printStackTrace();
        }


    }
}
