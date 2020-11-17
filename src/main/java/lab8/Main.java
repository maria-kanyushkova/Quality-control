package lab8;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class Main {
    public static void SendRequest(String url) throws Exception {
        URL obj = new URL(url);;
        HttpURLConnection connection = (HttpURLConnection) obj.openConnection();

        connection.setRequestMethod("GET");
        connection.connect();

        System.out.print(" Status Code: " +connection.getResponseCode());
        BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        String inputLine;
        StringBuilder response = new StringBuilder();

        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();

        System.out.println(" Body: " + response.toString());
    }

    public static void main(String[] args) throws Exception {

        System.out.print("MockQuerry = '" + "http://localhost:2530/request/ping");
        SendRequest("http://localhost:2530/request/ping");

        System.out.print("MockQuerry = '" + "http://localhost:2530/request/5");
        SendRequest("http://localhost:2530/request/5");

        System.out.print("MockQuerry = '" + "http://localhost:2530/request/404");
        SendRequest("http://localhost:2530/request/404");
    }
}
