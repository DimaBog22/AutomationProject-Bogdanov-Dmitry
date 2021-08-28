package PageObjects;

import org.openqa.selenium.By;
import org.testng.Assert;

import java.util.Locale;

public class ProductPage extends BasePage {
    private By title = By.cssSelector("[class=title]");
    private By logo = By.cssSelector("[class=app_logo]");
    private By filter = By.tagName("select");

    public ProductPage verifyProductPage() {

        isDisplayed(title, logo, filter);
        return this;

    }

    public ProductPage checkTitle() {

        String actualResult = getElementText(title).toLowerCase(Locale.ROOT);
        Assert.assertEquals(actualResult, "Products".toLowerCase());
        return this;

    }

}