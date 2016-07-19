import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.HashSet;
import java.util.Set;

public class GoogleHandler extends AWebHandler {
    private static GoogleHandler obj = new GoogleHandler();

    public static GoogleHandler getHandler() {
        return obj;
    }

    public Set<String> getData(String query, int num, String website) {
        Set<String> result = new HashSet<String>();
        String request = "https://www.google.com/search?q=" + query + "&num=" + num;
        if (!website.equals(""))
            request += "&as_sitesearch=" + website;

        Document doc = webRequest(request);
        if (doc == null)
            return null;
        Elements linkNames = doc.getElementsByTag("cite");
        for (Element link : linkNames)
            result.add(link.text());
        return result;
    }
}
