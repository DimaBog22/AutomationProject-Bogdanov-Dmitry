package PageObject.Saucedemo;

import PageObject.BasePage;
import org.openqa.selenium.By;
import org.testng.Assert;

public class LoginPage extends BasePage {
    private By username = By.cssSelector("[data-test=username]");
    private By password = By.cssSelector("[data-test=password]");
    private By loginBtn = By.cssSelector("[data-test=login-button]");
    private By errorTxt = By.cssSelector("[data-test=error]");

/*
    Patten Fluent / Chain of Invocations
*/

    public LoginPage verifyLoginPage() {
        isDisplayed(username, password, loginBtn);
        return this;
    }

    public LoginPage openPage() {
        openUsingProperties();
        return this;
    }

    public LoginPage openPage(String url) {
        open(url);
        return this;
    }

    public LoginPage enterUsername(String username) {
        enter(this.username, username);
        return this;
    }

    public LoginPage enterPassword(String password) {
        enter(this.password, password);
        return this;
    }

    public LoginPage clickLogin() {
        click(this.loginBtn);
        return this;
    }

    public LoginPage loginToApplication(String username, String password) {
        enter(this.username, username);
        enter(this.password, password);
        click(this.loginBtn);

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        return this;

    }

    public LoginPage checkErrorText(String expectedText) {
        Assert.assertEquals(getElementText(errorTxt), expectedText);
        return this;
    }
}