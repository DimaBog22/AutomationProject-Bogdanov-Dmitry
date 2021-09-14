package AppPropertiesTests;

import PageObjects.Saucedemo.LoginPage;
import PageObjects.Saucedemo.ProductPage;
import driver.BaseTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

    public class AppPropertiesLoginTest extends BaseTest {
        LoginPage loginPage = new LoginPage();
        ProductPage productPage = new ProductPage();

        @BeforeMethod
        public void precondition() {
            loginPage.openPage();
        }

        @Test(priority = 1)
        public void loginToApplicationStandard_Test() throws InterruptedException {
            loginPage.openPage()
                    .verifyLoginPage()
                    .loginToApplication("standard_user", "secret_sauce");
            productPage.verifyProductPage();
        }

}

