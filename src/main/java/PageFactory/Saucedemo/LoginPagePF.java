package PageFactory.Saucedemo;

import PageObject.Saucedemo.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import static driver.DriverCreation.*;

public class LoginPagePF extends BasePage {

    /*
        Page Factory pattern
    */

    @FindBy(css = "[data-test=username]")
    WebElement username;
    @FindBy(css = "[data-test=password]")
    WebElement password;
    @FindBy(css = "[data-test=login-button]")
    WebElement loginBtn;

    public LoginPagePF(WebDriver driver) {

        PageFactory.initElements(getDriver(), this);

    }
    /*
        Page Factory pattern
    */

    // ---------- //

    /*
        Fluent / Chain of Invocations pattern
    */
    public LoginPagePF openPage(String link) {

        open(link);
        return this;

    }

    public LoginPagePF verifyPage() {

        this.username.isDisplayed();
        this.password.isDisplayed();
        this.loginBtn.isDisplayed();
        return this;

    }

    public LoginPagePF loginToApplication(String username, String password) {

        this.username.sendKeys(username);
        this.password.sendKeys(password);
        loginBtn.click();

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        return this;

    }

}
