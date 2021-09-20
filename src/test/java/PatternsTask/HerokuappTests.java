package PatternsTask;

import PageFactory.Saucedemo.UserBuilder;
import PageObject.Herokuapp.HomePageObject;
import PageObject.Herokuapp.LoginPageObject;
import driver.BaseTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static PageObject.Herokuapp.HomePageLinksEnum.LOGIN_PAGE;

public class HerokuappTests extends BaseTest {

    HomePageObject homePageObject;
    LoginPageObject loginPageObject;

    UserBuilder user = new UserBuilder.Builder()
            .withUsername("tomsmith")
            .withPassword("SuperSecretPassword!")
            .build();

    @BeforeClass
    public void precondition() {

        loginPageObject = new LoginPageObject();
        homePageObject = new HomePageObject();

        homePageObject
                .open()
                .clickLink(LOGIN_PAGE);

    }
    @Test
    public void loginTest() {

        loginPageObject
                .verifyPageTitle()
                .loginIntoApplication(user)
                .isAuthSuccessful();
    }

}
