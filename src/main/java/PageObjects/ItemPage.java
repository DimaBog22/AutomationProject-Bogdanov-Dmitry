package PageObjects;

import org.openqa.selenium.By;

public class ItemPage extends BasePage {

    private By backToProductsBtn = By.id("back-to-products");
    private By itemName = By.cssSelector(".inventory_details_name.large_size");
    private By itemPrice = By.cssSelector(".inventory_details_price");
    private By removeBtn = By.name("remove-sauce-labs-backpack");

    public ItemPage verifyItemPage() {

        isDisplayed(backToProductsBtn, itemName, itemPrice, removeBtn);
        return this;

    }

    public ItemPage removeItemFromItemPage() throws InterruptedException {

        click(removeBtn);
        Thread.sleep(2000);
        return this;

    }

}
