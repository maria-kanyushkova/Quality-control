package lab10;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

class DriverUtils {

    static ChromeDriver getDriver() {
        System.setProperty("webdriver.chrome.driver", "./chromedriver/chromedriver.exe");
        ChromeDriver driver = new ChromeDriver();
        driver.get(Data.PATH);
        return driver;
    }

    private static void textInputField(ChromeDriver driver, String using, String keysToSend) {
        driver.findElementByName(using).sendKeys(keysToSend);
    }

    static void goMainPage(ChromeDriver driver) {
        findElementByClassNameAndClick(driver, "logo");
    }

    static void orderRegistration(ChromeDriver driver) {
        findElementByClassNameAndClick(driver, "btn-primary");
        findElementByClassNameAndClick(driver, "btn-default");
    }

    static WebElement findElementByClassName(ChromeDriver driver, String using) {
        return driver.findElement(By.className(using));
    }

    static WebElement findElementByXpath(ChromeDriver driver, String using) {
        return driver.findElement(By.xpath(using));
    }

    static String getTextElementByClassName(ChromeDriver driver, String using) {
        return driver.findElementByClassName(using).getText();
    }

    static void findTextInput(ChromeDriver driver, String text) {
        findElementByClassNameAndClick(driver, "search-bar");
        textInputField(driver, "s", text);
        findElementAndClick(driver, By.cssSelector("input[type='submit']"));
    }

    private static void findElementByClassNameAndClick(ChromeDriver driver, String using) {
        driver.findElementByClassName(using).click();
    }

    private static void findElementAndClick(ChromeDriver driver, By by) {
        driver.findElement(by).click();
    }

    static void login(ChromeDriver driver, String login, String password) {
        findElementByClassNameAndClick(driver, "btn-group");
        findElementAndClick(driver, By.xpath("//a[@href='user/login']"));
        textInputField(driver, "login", login);
        textInputField(driver, "password", password);
        findElementByClassNameAndClick(driver, "btn-default");
    }

    static void addProductToBasket(ChromeDriver driver) {
        findElementByClassNameAndClick(driver, "product-main");
        findElementByClassNameAndClick(driver, "item_add");
        driver.manage().window().maximize();
    }
}
