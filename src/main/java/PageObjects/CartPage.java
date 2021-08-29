package PageObjects;

import org.openqa.selenium.By;
import org.testng.Assert;

import java.util.Locale;

public class CartPage extends BasePage {

    private By title = By.cssSelector(".title");
    private By quantityItmes = By.cssSelector(".cart_quantity");
    private By itemName = By.cssSelector(".inventory_item_name");
    private By removeBtn = By.cssSelector("[data-test=remove-sauce-labs-backpack]");
    private By checkoutBtn = By.id("checkout");
    private By openCartBtn = By.cssSelector(".shopping_cart_link");

    public CartPage openCartPage() {

        click(openCartBtn);
        return this;

    }

    public CartPage verifyCartPage() {

        isDisplayed(title, quantityItmes, itemName, removeBtn, checkoutBtn);
        return this;

    }

    public CartPage checkTitle() {

        String actualResult = getElementText(title).toLowerCase(Locale.ROOT);
        Assert.assertEquals(actualResult, "Your Cart".toLowerCase(Locale.ROOT));
        return this;

    }

    public CartPage quantityIsOne() throws InterruptedException {

        String actualResult = getElementText(quantityItmes);
        Assert.assertEquals(actualResult, "1");
        Thread.sleep(3000);
        System.out.println(actualResult);
        return this;

    }

    public CartPage removeFromCart() {

        click(removeBtn);
        return this;

    }

    public CartPage goToCheckOut() {

        click(checkoutBtn);
        return this;

    }

}
