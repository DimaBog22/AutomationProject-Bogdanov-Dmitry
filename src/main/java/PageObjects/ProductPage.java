package PageObject;

import org.openqa.selenium.By;

public class ProductPage extends BasePage {
    private By title = By.cssSelector("[class=title]");
    private By logo = By.cssSelector("[class=app_logo]");
    private By filter = By.tagName("select");

    public ProductPage verifyProductPage() {
        isDisplayed(title, logo, filter);
        return this;
    }
}