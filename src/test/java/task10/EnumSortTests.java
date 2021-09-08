package task10;

import PageObjects.BasePage;
import PageObjects.LoginPage;
import PageObjects.ProductPage;
import driver.Listener;
import io.qameta.allure.Description;
import io.qameta.allure.Step;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import static PageObjects.FilterEnum.*;

@Listeners(Listener.class)
public class EnumSortTests extends BasePage {

    LoginPage loginPage = new LoginPage();
    ProductPage productPage = new ProductPage();
    String username = "standard_user";
    String password = "secret_sauce";

    @Test
    public void nameAZFilterTest() {

        loginPage.
                openPage()
                .verifyLoginPage()
                .loginToApplication(username, password);

        productPage.
                verifyProductPage()
                .selectOption(NAME_A_Z)
                .sortByNameAZ();
    }
    @Test
    public void nameZAFilterTest() {

        loginPage.
                openPage()
                .verifyLoginPage()
                .loginToApplication(username, password);

        productPage.
                verifyProductPage()
                .selectOption(NAME_Z_A)
                .sortByNameZA();
    }
    @Test
    public void priceLHFilterTest() {

        loginPage.
                openPage()
                .verifyLoginPage()
                .loginToApplication(username, password);

        productPage.
                verifyProductPage()
                .selectOption(PRICE_L_H)
                .sortByPriceLH();
    }
    @Step("Sort From High to Low value by price")
    @Description("Take a screenshot when test is failed")
    @Test
    public void priceHLFilterTest() {

        loginPage.
                openPage()
                .verifyLoginPage()
                .loginToApplication(username, password);

        productPage.
                verifyProductPage()
                .selectOption(PRICE_H_L)
                .sortByPriceHL();
    }


}
