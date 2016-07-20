import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.HashSet;
import java.util.Set;

public class TwitterHandler extends AWebHandler {
    private static TwitterHandler obj = new TwitterHandler();

    public static TwitterHandler getHandler() {
        return obj;
    }

    public String getUsername(String url) {
        String[] tokens = url.split("/");
        for (int i = 0; i < tokens.length; i++) {
            if (tokens[i].equalsIgnoreCase("twitter.com")) {
                if (++i < tokens.length)
                    return tokens[i];
                break;
            }
        }
        return null;
    }

    public String getProfileUrl(String username) {
        return "http://twitter.com" + username;
    }

    public boolean isProfileUrl(String url) {
        String[] tokens = url.split("/");
        for (int i = 0; i < tokens.length; i++) {
            if (tokens[i].equalsIgnoreCase("twitter.com")) {
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
        Element name = doc.select("a.ProfileHeaderCard-nameLink").first();
        return name.text();
    }

    public Set<String> getLinks(String url) {
        Set<String> result = new HashSet<String>();
        Document doc = webRequest(url);
        if (doc == null)
            return null;
        Elements links = doc.select("div.ProfileHeaderCard");
        links = links.select("a");
        for(Element link: links)
            if(getDomainName(link.attr("href")).equals("t.co"))
                result.add(link.text());
        return result;
    }

}
