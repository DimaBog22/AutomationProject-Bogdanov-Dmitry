package task10;

import PageObjects.LoginPage;
import PageObjects.ProductPage;
import driver.BaseTest;
import driver.Retry;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Optional;
import org.testng.annotations.Test;

public class DataProviderTests extends BaseTest {

    LoginPage loginPage = new LoginPage();
    ProductPage productPage = new ProductPage();
    // data for tests
    String username = "standard_user";
    String password = "secret_sauce";
    String emptyField = "";
    String incorrectValue = "rrrddd23";
    String emptyUsernameError = "Epic sadface: Username is required";
    String emptyPasswordError = "Epic sadface: Password is required";
    String incorrectValueError = "Epic sadface: Username and password do not match any user in this service";

    @DataProvider(name = "loginTests", parallel=true)
    public Object [][] loginInputData() {

        return new Object[][]{

                {username, password, emptyField}, // positive
                {username, emptyField, emptyPasswordError},
                {emptyField, password, emptyUsernameError},
                {emptyField, emptyField, emptyUsernameError},
                {username, incorrectValue, incorrectValueError},
                {incorrectValue, password, incorrectValueError},
                {incorrectValue, incorrectValue, incorrectValueError}

        };

    }
    @Test(dataProvider = "loginTests", retryAnalyzer = Retry.class)
    public void loginVerification(String username, String password, @Optional("") String errorText) {

        loginPage.
                openPage()
                .verifyLoginPage()
                .loginToApplication(username, password);
        if (errorText.isEmpty()) {
            productPage.verifyProductPage();
        } else {
            loginPage.checkErrorText(errorText);
        }

    }

}
