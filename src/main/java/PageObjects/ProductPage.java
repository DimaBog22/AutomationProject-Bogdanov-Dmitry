package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import PageObjects.FilterEnum.*;

import static driver.DriverCreation.getDriver;

public class ProductPage extends BasePage {
    private By title = By.cssSelector("[class=title]");
    private By logo = By.cssSelector("[class=app_logo]");
    private By filter = By.tagName("select");
    private By addBtn = By.id("add-to-cart-sauce-labs-backpack");
    private By cartBadge = By.cssSelector(".shopping_cart_badge");
    private By productItem = By.id("item_4_img_link");
    private By select = By.cssSelector(".product_sort_container");

    public ProductPage verifyProductPage() {

        isDisplayed(title, logo, filter);
        return this;

    }

    public ProductPage checkProductPageTitle() {

        checkTitle(title, "Products");
        return this;

    }

    public ProductPage addToCart() {

        click(addBtn);
        return this;

    }

    public ProductPage isCartBadgeEqualsOne() {

        String actualResult = getElementText(cartBadge);
        Assert.assertEquals(actualResult, "1");
        System.out.println(actualResult);

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        return this;

    }

    public ProductPage isCartBadgeEmpty() {

        isElementPresented(cartBadge);

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        System.out.println("item is deleted");
        return this;

    }

    public ProductPage openItemPage() {

        click(productItem);
        return this;

    }

    public ProductPage selectOption(FilterEnum filterEnum) {

        Select selector = new Select(getDriver().findElement(select));
        selector.selectByValue(filterEnum.getOption());
        return this;

    }

}