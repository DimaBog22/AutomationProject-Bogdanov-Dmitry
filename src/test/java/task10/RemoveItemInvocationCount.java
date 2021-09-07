package task10;

import PageObjects.CartPage;
import PageObjects.LoginPage;
import PageObjects.ProductPage;
import driver.BaseTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class RemoveItemInvocationCount extends BaseTest {

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
