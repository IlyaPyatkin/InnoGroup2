import java.util.HashMap;

public class Person {
    private HashMap<String, String> attributes = new HashMap<String, String>();

    public String attr(String a) {
        return attributes.get(a);
    }

    public void attr(String a, String anew) {
        attributes.put(a, anew);
    }
}
