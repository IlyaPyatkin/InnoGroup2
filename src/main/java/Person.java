import java.util.HashMap;
import java.util.LinkedList;

public class Person {
    private HashMap<String, LinkedList<String>> attributes = new HashMap<String, LinkedList<String>>();

    public String[] get(String attr) {
        if (!attributes.containsKey(attr))
            return null;
        LinkedList<String> list = attributes.get(attr);
        return list.toArray(new String[list.size()]);
    }

    public void add(String attr, String value) {
        LinkedList<String> list = attributes.get(attr);
        if (list == null)
            attributes.put(attr, new LinkedList<String>());
        attributes.get(attr).add(value);
    }
}
