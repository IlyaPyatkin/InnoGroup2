import java.util.HashSet;
import java.util.Set;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class GoogleHandler extends WebHandler{
    private static GoogleHandler obj = new GoogleHandler();

    public static GoogleHandler getHandler() {
        return obj;
    }

    public Set<String> getData(String query, String website) {
        Set<String> result = new HashSet<String>();
        String request = "https://www.google.com/search?q=" + query + "&num=5";
        if (!website.equals(""))
            request += "&as_sitesearch=" + website;

        Document doc = webRequest(request);
        if(doc == null)
            return null;
        Elements linkNames = doc.getElementsByTag("cite");
        for (Element link : linkNames)
            result.add(link.text());
        return result;
    }
}
