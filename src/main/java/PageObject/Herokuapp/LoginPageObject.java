package PageObject.Herokuapp;

import PageFactory.Saucedemo.UserBuilder;
import PageObject.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.testng.Assert;
import java.util.function.Function;
import static driver.DriverCreation.getDriver;

public class LoginPageObject extends BasePage {

    private By title = By.tagName("h2");
    private By username = By.id("username");
    private By password = By.id("password");
    private By loginBtn = By.tagName("button");
    private By successText = By.cssSelector(".flash.success");

    Wait wait = new Wait() {

        @Override
        public Object until(Function function) {
            return null;
        }

    };

    public LoginPageObject verifyPageTitle() {

        Assert.assertEquals(getElementText(title), "Login Page");
        return this;

    }

    public LoginPageObject clickloginBtn() {

        click(loginBtn);
        return this;

    }

    /*
        Value Object pattern
    */
    // using Builder pattern
    public LoginPageObject loginIntoApplication(UserBuilder user) {

        enter(username, user.getUsername());
        enter(password, user.getPassword());
        clickloginBtn();

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        return this;

    }

    public LoginPageObject loginIntoApplication(String username, String password) {

        enter(this.username, username);
        enter(this.password, password);
        clickloginBtn();

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        return this;

    }
    /*
        Value Object pattern
    */

    public LoginPageObject isAuthSuccessful() {

        wait.until(ExpectedConditions.visibilityOf(getDriver().findElement(successText)));
        return this;

    }

}
