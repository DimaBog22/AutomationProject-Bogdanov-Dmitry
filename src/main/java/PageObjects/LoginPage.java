package PageObjects;

import driver.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {
    private By userName = By.cssSelector("[data-test=username]");
    private By password = By.cssSelector("[data-test=password]");
    private By loginBtn = By.cssSelector("[data-test=login-button]");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public LoginPage openPage() {
        driver.get("https://www.saucedemo.com/");
        return this;
    }

    public LoginPage fillAuthFields(String userName, String password) {
        driver.findElement(this.userName).sendKeys(userName);
        driver.findElement(this.password).sendKeys(password);
        driver.findElement(this.loginBtn).click();
        return this;
    }

    public LoginPage clickLoginBtn() {
        super.click(loginBtn);
        return this;
    }

    public LoginPage enterLogin(String userName) {
        super.enter(this.userName, userName);
        return this;
    }

    public LoginPage enterPassword(String password) {
        super.enter(this.password, password);
        return this;
    }
}