import PageObjects.LoginPage;
import PageObjects.ProductPage;
import driver.BaseTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Task_9 extends BaseTest {

    LoginPage loginPage = new LoginPage();
    ProductPage productPage = new ProductPage();

    @BeforeTest
    public void preconditions(){
        loginPage.openPage();
    }

    @Test
    public void standardUserLogin(){

        loginPage.
                verifyLoginPage()
                .loginToApplication("standard_user", "secret_sauce");

        productPage.
                verifyProductPage()
                .checkTitle();

    }

    @Test
    public void standardLogin(){

        loginPage.
                verifyLoginPage()
                .loginToApplication("standard_user", "secret_sauce");

        productPage.
                verifyProductPage()
                .checkTitle();

    }

}
