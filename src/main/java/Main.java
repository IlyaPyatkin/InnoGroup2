import java.util.Scanner;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Person person = new Person();
        Scanner sc = new Scanner(System.in);
        System.out.println("\nEnter name or login of who you're looking for:");
        String search;
        search= sc.nextLine();
        sc.close();
        //search = "Alberto Sillitti";

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
        if(person.get("twitter") != null) {
            for (String link : twitter.getLinks(person.get("twitter")[0]))
                System.out.println(link);
            AWebHandler.openWebpage(person.get("twitter")[0]);
        }
    }
}