package task10;

import PageObjects.LoginPage;
import driver.BaseTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderTests extends BaseTest {

    LoginPage loginPage = new LoginPage();
    // data for tests
    String username = "standard_user";
    String password = "secret_sauce";
    String emptyField = "";
    String incorrectValue = "rrrddd23";

    @DataProvider(name = "loginTests")
    public Object [][] loginInputData() {

        return new Object[][]{

                {username, password}, // positive
                {username, emptyField},
                {emptyField, password},
                {emptyField, emptyField},
                {username, incorrectValue},
                {incorrectValue, password},
                {incorrectValue, incorrectValue}

        };

    }
    @Test(dataProvider = "loginTests")
    public void loginVerification(String username, String password) {

        loginPage.
                openPage()
                .verifyLoginPage()
                .loginToApplication(username, password);
    }

}
