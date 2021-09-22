package LombokAndLogsTask;

import PageObject.Saucedemo.CartPage;
import PageObject.Saucedemo.LoginPage;
import PageObject.Saucedemo.ProductPage;
import driver.BaseTest;
import org.testng.annotations.Test;
import properties.PropertyReader;

import static PageObject.Saucedemo.FilterEnum.NAME_Z_A;

public class LombokSauceTest extends BaseTest {

    LoginPage loginPage = new LoginPage();
    ProductPage productPage = new ProductPage();

    PropertyReader appProperties = new PropertyReader("config/config.properties");
    String link = appProperties.getProperties().getProperty("url");
    String username = appProperties.getProperties().getProperty("standardloginSauce");
    String password = appProperties.getProperties().getProperty("passwordSauce");
    // builder pattern using Lombok
    User user = new User.UserBuilder()
            .username(username)
            .password(password)
            .build();

    @Test
    public void loginTest() {

        loginPage
                .openPage(link)
                .verifyLoginPage()
                .loginToApplication(user.getUsername(), user.getPassword());

    }
    @Test
    public void addItem() {

        loginPage.
                openPage(link)
                .verifyLoginPage()
                .loginToApplication(user.getUsername(), user.getPassword());

        productPage.
                verifyProductPage()
                .addToCart()
                .isCartBadgeEqualsOne();

    }
    @Test
    public void nameZAFilterTest() {

        loginPage.
                openPage(link)
                .verifyLoginPage()
                .loginToApplication(user.getUsername(), user.getPassword());
        System.out.println(user.getPassword());

        productPage.
                verifyProductPage()
                .selectOption(NAME_Z_A)
                .sortByNameZA();
    }

}
