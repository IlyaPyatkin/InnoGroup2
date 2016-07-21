import java.util.Scanner;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Person person = new Person();
        Scanner sc = new Scanner(System.in);
        String search;
        //search= sc.nextLine();
        search = "Alberto Sillitti";

        GoogleHandler google = GoogleHandler.getHandler();
        TwitterHandler twitter = TwitterHandler.getHandler();
        Set<String> result = google.getData(search, 5, "twitter.com");
        for (String str : result) {
            if(twitter.isProfileUrl(str)) {
                person.add("twitter", str);
                person.add("nick", twitter.getUsername(str));
                person.add("name", twitter.getName(str));
                break;
            }
        }
        Set<String> twitterLinks = twitter.getLinks(person.get("twitter")[0]);
        for (String link : twitterLinks)
            System.out.println(link);
        AWebHandler.openWebpage(person.get("twitter")[0]);
    }
}