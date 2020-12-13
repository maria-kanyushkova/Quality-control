package lab2;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class BrokenLink2 {
    public static List<String> readLink(String baseLink, String linkPage) {
        Document document;
        List<String> listOfLinks = new ArrayList<>();
        try {
            document = Jsoup.connect(linkPage).get();
            Elements links = document.select("a[href]");
            for (Element link : links) {
                if (link != null) {
                    String tempLink = link.attr("href");
                    if (getResponseCode(tempLink) == 200) {
                        listOfLinks.add(tempLink);
                    } else if (tempLink.contains("../")) {
                        listOfLinks.add(baseLink.substring(0, 22) + tempLink.substring(3));
                    } else if (tempLink.charAt(0) == '#') {
                        listOfLinks.add(baseLink + "/" + tempLink);
                    } else if (tempLink.contains(".htm")) {
                        listOfLinks.add(baseLink + "/" + tempLink);
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listOfLinks.stream().distinct().collect(Collectors.toList());
    }

    public static int getResponseCode(String link) {
        URL url;
        HttpURLConnection con = null;
        int responseCode = 0;
        try {
            url = new URL(link);
            con = (HttpURLConnection) url.openConnection();
            responseCode = con.getResponseCode();
        } catch (Exception e) {
            // skip
        } finally {
            if (null != con)
                con.disconnect();
        }
        return responseCode;
    }
}
