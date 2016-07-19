import java.util.Scanner;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String search;
        //search= sc.nextLine();
        search = "Notch";
        Person person = new Person();
        Set<String> result = GoogleHandler.getHandler().getData(search, 1, "twitter.com");
        for (String str : result) {
            person.attr("twitter", str);
            AWebHandler.openWebpage(str);
            System.out.println(str);
        }
    }
}