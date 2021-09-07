package task10;

import PageObjects.CartPage;
import PageObjects.LoginPage;
import PageObjects.ProductPage;
import driver.BaseTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class AddItemInvocationCountTest extends BaseTest {

    LoginPage loginPage = new LoginPage();
    ProductPage productPage = new ProductPage();
    CartPage cartPage = new CartPage();

    @Parameters({"username", "password"})
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
