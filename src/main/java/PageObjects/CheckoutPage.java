package PageObjects;

import org.openqa.selenium.By;
import org.testng.Assert;
import java.util.Locale;

public class CheckoutPage extends BasePage {

    private By title = By.cssSelector(".title");
    private By form = By.tagName("form");
    private By firstName = By.id("first-name");
    private By lastName = By.id("last-name");
    private By postalCode = By.id("postal-code");
    private By continueBtn = By.id("continue");

    public CheckoutPage verifyCheckoutPage() {

        isDisplayed(title, form);
        return this;

    }

    public CheckoutPage checkTitle() {

        String actualResult = getElementText(title).toLowerCase(Locale.ROOT);
        Assert.assertEquals(actualResult, "Checkout: Your Information".toLowerCase(Locale.ROOT));
        return this;

    }

    public CheckoutPage fillForm(String firstName, String lastName, String postalCode) {
        enter(this.firstName, firstName);
        enter(this.lastName, lastName);
        enter(this.postalCode, postalCode);
        click(this.continueBtn);
        return this;
    }

}
