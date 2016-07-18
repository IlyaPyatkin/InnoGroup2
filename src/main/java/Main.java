import java.util.Set;

public class Main {
    public static void main(String[] args) {
        GoogleHandler webHandler = GoogleHandler.getHandler();
        Set<String> result = webHandler.getData("ehotka", "vk.com");
        for(String str: result)
            System.out.println(str);
    }
}