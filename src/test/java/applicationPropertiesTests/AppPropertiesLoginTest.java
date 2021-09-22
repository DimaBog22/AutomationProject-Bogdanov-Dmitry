package applicationPropertiesTests;

import PageObject.Saucedemo.LoginPage;
import PageObject.Saucedemo.ProductPage;
import driver.BaseTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import properties.PropertyReader;

public class AppPropertiesLoginTest extends BaseTest {
        LoginPage loginPage = new LoginPage();
        ProductPage productPage = new ProductPage();

        // using config.properties file
        PropertyReader appProperties = new PropertyReader("config/config.properties");
        String username = appProperties.getProperties().getProperty("standardloginSauce");
        String password = appProperties.getProperties().getProperty("passwordSauce");

        @BeforeMethod
        public void precondition() {
            loginPage.openPage();
        }

        @Test()
        public void loginToApplicationStandard_Test() throws InterruptedException {
            loginPage.openPage()
                    .verifyLoginPage()
                    .loginToApplication(username, password);
            productPage.verifyProductPage();
        }

}

