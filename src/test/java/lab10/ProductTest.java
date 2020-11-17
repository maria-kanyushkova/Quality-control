package lab10;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ProductTest {
    private static ChromeDriver driver = DriverUtils.getDriver();

    @Test
    public void test_01_FailLogin() {
        DriverUtils.goMainPage(driver);
        DriverUtils.login(driver, Data.LOGIN, Data.INVALID_PASSWORD);

        WebElement result = DriverUtils.findElementByClassName(driver, "alert-danger");
        assertTrue(result.isDisplayed(), "Fail login");
    }

    @Test
    public void test_02_SuccessLogin() {
        DriverUtils.goMainPage(driver);
        DriverUtils.login(driver, Data.LOGIN, Data.PASSWORD);

        WebElement result = DriverUtils.findElementByClassName(driver, "alert-success");
        assertTrue(result.isDisplayed(), "Success login");
    }

    @Test
    public void test_03_FindProduct() {
        DriverUtils.goMainPage(driver);
        DriverUtils.findTextInput(driver, Data.SEARCH_EXPRESSION);

        WebElement result = DriverUtils.findElementByXpath(driver, "//h3[contains(text(), 'CASIO MRP-700-1AVEF')]");
        assertTrue(result.isDisplayed(), "Found " + Data.SEARCH_EXPRESSION);
    }

    @Test
    public void test_04_OrderRegistration() {
        DriverUtils.goMainPage(driver);

        DriverUtils.addProductToBasket(driver);
        DriverUtils.orderRegistration(driver);

        WebElement result = DriverUtils.findElementByClassName(driver, "alert-success");
        assertTrue(result.isDisplayed(), "Order registration");
    }

    @Test
    public void test_05_AddProductToBasket() {
        DriverUtils.goMainPage(driver);
        DriverUtils.addProductToBasket(driver);

        String result = DriverUtils.getTextElementByClassName(driver, "simpleCart_total");
        assertNotEquals("Empty Cart", result, "Product add to basket");
    }
}
