package task10;

import PageObject.Saucedemo.CartPage;
import PageObject.Saucedemo.LoginPage;
import PageObject.Saucedemo.ProductPage;
import driver.BaseTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class AddItemInvocationCountTest extends BaseTest {

    LoginPage loginPage = new LoginPage();
    ProductPage productPage = new ProductPage();
    CartPage cartPage = new CartPage();

    @Parameters({"username", "passwordSauce"})
    @Test(invocationCount = 2,  timeOut = 10000)
    public void addItem(String username, String password) {

        loginPage.
                openPage()
                .verifyLoginPage()
                .loginToApplication(username, password);

        productPage.
                verifyProductPage()
                .addToCart()
                .isCartBadgeEqualsOne();

        closeDriver();

    }

}
