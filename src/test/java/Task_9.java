import PageObjects.LoginPage;
import PageObjects.ProductPage;
import driver.BaseTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Task_9 extends BaseTest {

    // pages
    LoginPage loginPage = new LoginPage();
    ProductPage productPage = new ProductPage();

    // creds
    String standard = "standard_user";
    String problem = "problem_user";
    String performance = "performance_glitch_user";
    String password = "secret_sauce";

    @BeforeMethod
    public void preconditions(){
        loginPage.openPage();
    }

//    @Test
    public void standardUserLogin(){

        loginPage.
                verifyLoginPage()
                .loginToApplication(standard, password);

        productPage.
                verifyProductPage()
                .checkTitle();

    }
//    @Test
    public void problemUserLogin(){

        loginPage.
                verifyLoginPage()
                .loginToApplication(problem, password);

        productPage.
                verifyProductPage()
                .checkTitle();

    }
//    @Test
    public void performanceUserLogin(){

        loginPage.
                verifyLoginPage()
                .loginToApplication(performance, password);

        productPage.
                verifyProductPage()
                .checkTitle();

    }
    @Test
    public void verifyUsernameIsRequired(){

        loginPage.
                verifyLoginPage()
                .enterPassword(password)
                .clickLogin()
                .checkErrorText("Epic sadface: Username is required");

    }
    @Test
    public void verifyPasswordIsRequired(){

        loginPage.
                verifyLoginPage()
                .enterUsername(standard)
                .clickLogin()
                .checkErrorText("Epic sadface: Password is required");

    }

}
