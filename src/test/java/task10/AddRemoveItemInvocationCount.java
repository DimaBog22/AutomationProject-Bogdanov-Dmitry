package task10;

import PageObjects.LoginPage;
import PageObjects.ProductPage;
import driver.Retry;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class AddRemoveItemInvocationCount {

    LoginPage loginPage = new LoginPage();
    ProductPage productPage = new ProductPage();

    @Parameters({"username", "password"})
    @Test(retryAnalyzer = Retry.class)
    public void addItem(String username, String password) {

        loginPage.
                openPage()
                .verifyLoginPage()
                .loginToApplication(username, password);

        productPage.verifyProductPage();

    }


}
