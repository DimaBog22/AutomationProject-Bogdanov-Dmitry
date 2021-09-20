package task10;

import PageObject.Saucedemo.CartPage;
import PageObject.Saucedemo.LoginPage;
import PageObject.Saucedemo.ProductPage;
import driver.BaseTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class RemoveItemInvocationCountTest extends BaseTest {

    LoginPage loginPage = new LoginPage();
    ProductPage productPage = new ProductPage();
    CartPage cartPage = new CartPage();

    @Parameters({"username", "password"})
    @Test
    public void removeItem(String username, String password) {

        loginPage.
                openPage()
                .verifyLoginPage()
                .loginToApplication(username, password);

        productPage.
                verifyProductPage()
                .addToCart()
                .isCartBadgeEqualsOne();

        cartPage.
                openCartPage()
                .verifyCartPage()
                .checkCartPageTitle()
                .quantityIsOne()
                .removeFromCart();

        productPage.
                isCartBadgeEmpty();

        closeDriver();

    }

}
