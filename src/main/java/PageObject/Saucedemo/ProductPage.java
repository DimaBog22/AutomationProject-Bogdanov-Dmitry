package PageObject.Saucedemo;

import PageObject.BasePage;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.util.*;
import java.util.stream.Collectors;

import static driver.DriverCreation.getDriver;
@Log4j2
public class ProductPage extends BasePage {
    private By title = By.cssSelector("[class=title]");
    private By logo = By.cssSelector("[class=app_logo]");
    private By filter = By.tagName("select");
    private By addBtn = By.id("add-to-cart-sauce-labs-backpack");
    private By cartBadge = By.cssSelector(".shopping_cart_badge");
    private By productItem = By.id("item_4_img_link");
    private By select = By.cssSelector(".product_sort_container");
    private By productNames = By.cssSelector(".inventory_item_name");
    private By productPrices = By.cssSelector(".inventory_item_price");

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
        log.info("cartBadge is " + actualResult);

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

    public ProductPage sortByNameAZ() {

        List<String> expectedData = getDriver().findElements(productNames).stream().map(data -> data.getText()).sorted().collect(Collectors.toList());
        List<String> actualData = getDriver().findElements(productNames).stream().map(data -> data.getText()).collect(Collectors.toList());
        Assert.assertEquals(expectedData, actualData);
        log.info("actual: " + actualData);
        log.info("expect: " + expectedData);
        return this;

    }

    public ProductPage sortByNameZA() {

        List<String> expectedData = getDriver().findElements(productNames).stream().map(data -> data.getText()).sorted(Comparator.reverseOrder()).collect(Collectors.toList());
        List<String> actualData = getDriver().findElements(productNames).stream().map(data -> data.getText()).collect(Collectors.toList());
        Assert.assertEquals(expectedData, actualData);
        log.info("actual: " + actualData);
        log.info("expect: " + expectedData);
        return this;

    }

    public ProductPage sortByPriceLH() {


        List<String> actualData = getDriver().findElements(productPrices).stream().map(data -> data.getText().replace("$", " ").trim()).collect(Collectors.toList());
        String [] expectedDataArr = {"7.99", "9.99", "15.99", "15.99", "29.99", "49.99"};
        List<String> expectedData = Arrays.asList(expectedDataArr);
        Assert.assertEquals(expectedData, actualData);
        log.info("actual: " + actualData);
        log.info("expect: " + expectedData);
        return this;

    }

    public ProductPage sortByPriceHL() {


        List<String> actualData = getDriver().findElements(productPrices).stream().map(data -> data.getText().replace("$", " ").trim()).sorted(Comparator.reverseOrder()).collect(Collectors.toList());
        String [] expectedDataArr = {"49.99", "9.99", "15.99", "15.99", "29.99", "7.99"};
        List<String> expectedData = Arrays.asList(expectedDataArr);
        Assert.assertEquals(expectedData, actualData);
        log.info("actual: " + actualData);
        log.info("expect: " + expectedData);
        return this;

    }


}