import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

public class FacebookHandler extends AWebHandler {
    private static FacebookHandler obj = new FacebookHandler();

    public static FacebookHandler getHandler() {
        return obj;
    }

    public String getUsername(String url) {
        String[] tokens = url.split("/");
        for (int i = 0; i < tokens.length; i++) {
            if (tokens[i].equalsIgnoreCase("www.facebook.com")) {
                if (++i < tokens.length)
                    return tokens[i];
                break;
            }
        }
        return null;
    }

    public boolean isProfileUrl(String url) {
        String[] tokens = url.split("/");
        for (int i = 0; i < tokens.length; i++) {
            if (tokens[i].equalsIgnoreCase("www.facebook.com") || tokens[i].equalsIgnoreCase("it-it.facebook.com")) {
                if (i + 2 < tokens.length)
                    break;
                if (i + 1 < tokens.length)
                    return true;
                break;
            }
        }
        return false;
    }

    public String getName(String url) {
        Document doc = webRequest(url);
        if (doc == null)
            return null;
        Element name = doc.select("a._8_2").first();
        return name.text();
    }
}
