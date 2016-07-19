import java.util.Scanner;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Person person = new Person();
        Scanner sc = new Scanner(System.in);
        String search;
        //search= sc.nextLine();
        search = "Notch";

        GoogleHandler gHandler = GoogleHandler.getHandler();
        Set<String> result = gHandler.getData(search, 1, "twitter.com");
        for (String str : result) {
            person.attr("twitter", str);
            TwitterHandler tHandler = TwitterHandler.getHandler();
            Set<String> twitterLinks = tHandler.getLinks("http://twitter.com/" + tHandler.getUsername(str));
            for (String link : twitterLinks)
                    System.out.println(link);
            //AWebHandler.openWebpage(str);
        }
    }
}