package PageFactory;

import driver.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static org.openqa.selenium.support.PageFactory.initElements;

public class LoginPage extends BasePage {
    @FindBy(css = "[data-test=username]")
    WebElement userName;

    @FindBy(css = "[data-test=password]")
    WebElement password;

    @FindBy(css = "[data-test=login-button]")
    WebElement loginBtn;

    public LoginPage(WebDriver driver) {
        super(driver);
        initElements(driver, this);
    }

    public LoginPage openPage() {
        driver.get("https://www.saucedemo.com/");
        return this;
    }

    public LoginPage fillAuthFields(String userName, String password) {
        this.userName.sendKeys(userName);
        this.password.sendKeys(password);
        this.loginBtn.click();
        return this;
    }
}