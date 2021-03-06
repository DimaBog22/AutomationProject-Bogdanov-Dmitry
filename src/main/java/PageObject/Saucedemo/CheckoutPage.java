package PageObject.Saucedemo;

import PageObject.BasePage;
import org.openqa.selenium.By;

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

    public CheckoutPage checkCheckoutPageTitle() {

        checkTitle(title, "Checkout: Your Information");
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
