package PatternsTask;

import PageFactory.Saucedemo.LoginPagePF;
import PageFactory.Saucedemo.UserBuilder;
import driver.BaseTest;
import org.testng.annotations.Test;
import properties.PropertyReader;

public class SaucedemoTests extends BaseTest {

    LoginPagePF loginPagePF = new LoginPagePF(driver);
    // data from properties file
    PropertyReader appProperties = new PropertyReader("config/config.properties");
    String link = appProperties.getProperties().getProperty("url");
    String username = appProperties.getProperties().getProperty("login");
    String password = appProperties.getProperties().getProperty("password");
    // using Builder pattern
    UserBuilder user = new UserBuilder.Builder()
            .withUsername(username)
            .withPassword(password)
            .build();



    @Test
    public void loginTest() {

        loginPagePF
                .openPage(link)
                .verifyPage()
                .loginToApplication(user.getUsername(), user.getPassword());

    }

}
