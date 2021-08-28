import PageObjects.LoginPage;
import PageObjects.ProductPage;
import driver.BaseTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Task_9 extends BaseTest {

    LoginPage loginPage = new LoginPage();
    ProductPage productPage = new ProductPage();

    @BeforeMethod
    public void preconditions(){
        loginPage.openPage();
    }

//    @Test
    public void standardUserLogin(){

        loginPage.
                verifyLoginPage()
                .loginToApplication("standard_user", "secret_sauce");

        productPage.
                verifyProductPage()
                .checkTitle();

    }
//    @Test
    public void problemUserLogin(){

        loginPage.
                verifyLoginPage()
                .loginToApplication("problem_user", "secret_sauce");

        productPage.
                verifyProductPage()
                .checkTitle();

    }
    @Test
    public void performanceUserLogin(){

        loginPage.
                verifyLoginPage()
                .loginToApplication("performance_glitch_user", "secret_sauce");

        productPage.
                verifyProductPage()
                .checkTitle();

    }

}
