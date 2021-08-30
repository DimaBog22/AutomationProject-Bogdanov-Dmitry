import PageObjects.*;
import driver.BaseTest;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Task_9 extends BaseTest {

    // pages
    LoginPage loginPage = new LoginPage();
    ProductPage productPage = new ProductPage();
    CartPage cartPage = new CartPage();
    ItemPage itemPage = new ItemPage();
    CheckoutPage checkoutPage = new CheckoutPage();
    CheckoutOverviewPage checkoutOverviewPage = new CheckoutOverviewPage();
    CheckoutCompletePage checkoutCompletePage = new CheckoutCompletePage();

    // creds
    String standard = "standard_user";
    String problem = "problem_user";
    String performance = "performance_glitch_user";
    String password = "secret_sauce";
    String usernameIsRequired = "Epic sadface: Username is required";
    String passwordIsRequired = "Epic sadface: Password is required";

    @BeforeMethod
    public void preconditions() {
        loginPage.openPage();
    }

    @Test
    public void removeItemFromCart() throws InterruptedException {

        loginPage.
                verifyLoginPage()
                .loginToApplication(standard, password);

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

    }
    @Test
    public void removeItemFromItemPage() throws InterruptedException {

        loginPage.
                verifyLoginPage()
                .loginToApplication(standard, password);

        productPage.
                verifyProductPage()
                .addToCart()
                .isCartBadgeEqualsOne();

        productPage.
                openItemPage();

        Thread.sleep(2000); // to check cartBadge is still 1

        itemPage.
                verifyItemPage()
                .removeItemFromItemPage();

        productPage.
                isCartBadgeEmpty();

    }
    @Test
    public void makePayment() throws InterruptedException {

        loginPage.
                verifyLoginPage()
                .loginToApplication(standard, password);

        productPage.
                verifyProductPage()
                .addToCart()
                .isCartBadgeEqualsOne();

        cartPage.
                openCartPage()
                .verifyCartPage()
                .checkCartPageTitle()
                .quantityIsOne()
                .goToCheckOut();

        checkoutPage.
                verifyCheckoutPage()
                .checkCheckoutPageTitle()
                .fillForm("Dmitry", "Bogdanov", "220113");

        checkoutOverviewPage.
                verifyCheckoutOverviewPage()
                .finishPayment();

        checkoutCompletePage.
                verifyCheckoutCompletePage()
                .getProofOfPayment();

    }

    @Test
    public void standardUserLogin() throws InterruptedException {

        loginPage.
                verifyLoginPage()
                .loginToApplication(standard, password);

        productPage.
                verifyProductPage()
                .checkProductPageTitle();

    }
    @Test
    public void problemUserLogin() throws InterruptedException {

        loginPage.
                verifyLoginPage()
                .loginToApplication(problem, password);

        productPage.
                verifyProductPage()
                .checkProductPageTitle();

    }
    @Test
    public void performanceUserLogin() throws InterruptedException {

        loginPage.
                verifyLoginPage()
                .loginToApplication(performance, password);

        productPage.
                verifyProductPage()
                .checkProductPageTitle();

    }
    @Test
    public void verifyUsernameIsRequired() {

        loginPage.
                verifyLoginPage()
                .enterPassword(password)
                .clickLogin()
                .checkErrorText(usernameIsRequired);

    }
    @Test
    public void verifyPasswordIsRequired() {

        loginPage.
                verifyLoginPage()
                .enterUsername(standard)
                .clickLogin()
                .checkErrorText(passwordIsRequired);

    }
    @Test
    public void addItemToCart() throws InterruptedException {

        loginPage.
                verifyLoginPage()
                .loginToApplication(standard, password);

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

    }


}
