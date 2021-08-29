import PageObjects.CartPage;
import PageObjects.LoginPage;
import PageObjects.ProductPage;
import driver.BaseTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Task_9 extends BaseTest {

    // pages
    LoginPage loginPage = new LoginPage();
    ProductPage productPage = new ProductPage();
    CartPage cartPage = new CartPage();

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

    //    @Test
    public void standardUserLogin() {

        loginPage.
                verifyLoginPage()
                .loginToApplication(standard, password);

        productPage.
                verifyProductPage()
                .checkTitle();

    }

    //    @Test
    public void problemUserLogin() {

        loginPage.
                verifyLoginPage()
                .loginToApplication(problem, password);

        productPage.
                verifyProductPage()
                .checkTitle();

    }

    //    @Test
    public void performanceUserLogin() {

        loginPage.
                verifyLoginPage()
                .loginToApplication(performance, password);

        productPage.
                verifyProductPage()
                .checkTitle();

    }

    //    @Test
    public void verifyUsernameIsRequired() {

        loginPage.
                verifyLoginPage()
                .enterPassword(password)
                .clickLogin()
                .checkErrorText(usernameIsRequired);

    }

    //    @Test
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
                .checkTitle()
                .quantityIsOne();

    }

}
