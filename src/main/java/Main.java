import java.util.Scanner;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Person person = new Person();
        Scanner sc = new Scanner(System.in);
        System.out.println("\nEnter name or login of who you're looking for:");
        String search = sc.nextLine();
        sc.close();

        GoogleHandler google = GoogleHandler.getHandler();
        TwitterHandler twitter = TwitterHandler.getHandler();
        FacebookHandler facebook = FacebookHandler.getHandler();

        Set<String> result;
        result = google.getData(search, 5, "twitter.com");
        for (String str : result) {
            if (twitter.isProfileUrl(str)) {
                person.add("twitter", str);
                person.add("nick", twitter.getUsername(str));
                person.add("name", twitter.getName(str));
                break;
            }
        }
        if (person.get("twitter") != null) {
            AWebHandler.openWebpage(person.get("twitter")[0]);
        }

        result = google.getData(search, 5, "facebook.com");
        for (String str : result) {
            if (facebook.isProfileUrl(str)) {
                person.add("facebook", str);
                break;
            }
        }
        if (person.get("facebook") != null) {
            AWebHandler.openWebpage(person.get("facebook")[0]);
        }
    }
}