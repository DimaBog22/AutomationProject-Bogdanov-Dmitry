package PageObjects;

import org.openqa.selenium.By;
import org.testng.Assert;

import java.util.Locale;

import static driver.DriverCreation.getDriver;

public class ProductPage extends BasePage {
    private By title = By.cssSelector("[class=title]");
    private By logo = By.cssSelector("[class=app_logo]");
    private By filter = By.tagName("select");
    private By addBtn = By.id("add-to-cart-sauce-labs-backpack");
    private By cartBadge = By.cssSelector(".shopping_cart_badge");
    private By productItem = By.id("item_4_img_link");

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

    public ProductPage isCartBadgeEmpty() throws InterruptedException {

        isElementPresented(cartBadge);
        Thread.sleep(2000);
        System.out.println("item is deleted");
        return this;

    }

    public ProductPage openItemPage() {

        click(productItem);
        return this;

    }

}