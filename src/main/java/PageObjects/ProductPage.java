package PageObjects;

import org.openqa.selenium.By;
import org.testng.Assert;

import java.util.Locale;

public class ProductPage extends BasePage {
    private By title = By.cssSelector("[class=title]");
    private By logo = By.cssSelector("[class=app_logo]");
    private By filter = By.tagName("select");
    private By addBtn = By.id("add-to-cart-sauce-labs-backpack");
    private By cartBadge = By.cssSelector(".shopping_cart_badge");

    public ProductPage verifyProductPage() {

        isDisplayed(title, logo, filter);
        return this;

    }

    public ProductPage checkTitle() {

        String actualResult = getElementText(title).toLowerCase(Locale.ROOT);
        Assert.assertEquals(actualResult, "Products".toLowerCase());
        return this;

    }

    public ProductPage addToCart() {

        click(addBtn);
        return this;

    }

    public ProductPage isCartBadgeEqualsOne() throws InterruptedException {

        String actualResult = getElementText(cartBadge);
        Assert.assertEquals(actualResult, "1");
        System.out.println(actualResult);
        Thread.sleep(3000);
        return this;

    }


}