package lab10;

import com.codeborne.selenide.Configuration;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.remote.DesiredCapabilities;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ProductTest {
    public static void toMainPage() {
        open(Config.PATH);
    }

    public static void login(String login, String password) {
        $(byText("Account")).click();
        $(byText("Вход")).click();
        $(byName("login")).setValue(login);
        $(byName("password")).setValue(password);
        $$(byTagName("button")).findBy(text("Вход")).click();
    }

    public static void search(String search) {
        $(byClassName("search-bar")).click();
        $(byName("s")).setValue(search).pressEnter();
    }

    public static void addProductToBasket() {
        $$(byClassName("add-to-cart-link")).get(0).click();
        $(byClassName("btn-primary")).click();
        $(byClassName("btn-default")).click();
    }

    @BeforeEach
    void setUp() {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setBrowserName("chrome");
        capabilities.setVersion("87.0");
        Configuration.browserCapabilities = capabilities;
    }

    @Test
    public void test_01_FailLogin() {
        toMainPage();
        login(Config.LOGIN, Config.INVALID_PASSWORD);

        assertEquals($(byClassName("alert-danger")).getText(), "Логин/пароль введены неверно");
    }

    @Test
    public void test_02_SuccessLogin() {
        toMainPage();
        login(Config.LOGIN, Config.PASSWORD);

        assertEquals($(byClassName("alert-success")).getText(), "Вы успешно авторизованы");
    }

    @Test
    public void test_03_FindProduct() {
        toMainPage();
        search(Config.SEARCH_EXPRESSION);

        assertFalse($$(byXpath("h3")).filterBy(text(Config.SEARCH_EXPRESSION)).isEmpty());
    }

    @Test
    public void test_04_OrderRegistration() {
        toMainPage();
        addProductToBasket();

        assertEquals($(byClassName("alert-success")).getText(), "Спасибо за Ваш заказ. В ближайшее время с Вами свяжется менеджер для согласования заказа");
    }
}
