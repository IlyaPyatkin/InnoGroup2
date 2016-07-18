import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Set<String> result = GoogleHandler.getHandler().getData("Oleg", "twitter.com");
        for (String str : result)
            AWebHandler.openWebpage(str);
        //    System.out.println(str);
    }
}