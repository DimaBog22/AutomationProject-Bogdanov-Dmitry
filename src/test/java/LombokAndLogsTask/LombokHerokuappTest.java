package LombokAndLogsTask;

import PageObject.Herokuapp.HomePageObject;
import PageObject.Herokuapp.LoginPageObject;
import driver.BaseTest;
import org.testng.annotations.Test;
import properties.PropertyReader;

import static PageObject.Herokuapp.HomePageLinksEnum.LOGIN_PAGE;

public class LombokHerokuappTest extends BaseTest {

    HomePageObject homePageObject = new HomePageObject();
    LoginPageObject loginPageObject = new LoginPageObject();

    PropertyReader propertyReader = new PropertyReader("config/config.properties");
    String username = propertyReader.getProperties().getProperty("loginHerokuapp");
    String password = propertyReader.getProperties().getProperty("passwordHerokuapp");

    User user = new User.UserBuilder()
            .username(username)
            .password(password)
            .build();

    @Test
    public void loginTest() {

        homePageObject
                .open()
                .clickLink(LOGIN_PAGE);

        loginPageObject
                .verifyPageTitle()
                .loginIntoApplication(user.getUsername(), user.getPassword())
                .isAuthSuccessful();


    }

}