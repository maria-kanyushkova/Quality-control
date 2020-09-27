package lab2;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrokenLink {
    public static Map<Integer, List<String>> getLinkAndCodes(String href) {
        System.setProperty("webdriver.chrome.driver", "D:\\dev_source\\chromedriver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get(href);

        Map<Integer, List<String>> map = driver.findElements(By.xpath("//a[@href]"))
                .stream()
                .map(ele -> ele.getAttribute("href"))
                .map(String::trim)
                .distinct()
                .collect(Collectors.groupingBy(BrokenLink::getResponseCode));

        driver.quit();
        return map;
    }

    public static int getResponseCode(String link) {
        URL url;
        HttpURLConnection con = null;
        Integer responseCode = 0;
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
