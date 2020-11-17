package lab8;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Arrays;
import java.util.List;

public class MainTest {
    public static String SendRequest(URL url) throws Exception {
        final HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("GET");

        final BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
        String inputLine;
        final StringBuilder content = new StringBuilder();
        while ((inputLine = in.readLine()) != null) {
            content.append(inputLine);
        }
        return content.toString();
    }

    public static void main(String[] args) throws Exception {
        List<URL> urls = Arrays.asList(new URL("http://localhost:2531/request/1"),
                new URL("http://localhost:2531/request/2"),
                new URL("http://localhost:2531 /request/3"));
        for (URL url : urls) {
            System.out.println("Url = '" + url.toString() + "'. Answer = '" + SendRequest(url) + "'.");
        }
    }
}
