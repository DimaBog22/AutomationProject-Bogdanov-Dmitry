package PageObject.Saucedemo;

import PageObject.BasePage;
import org.openqa.selenium.By;

public class CheckoutCompletePage extends BasePage {

    private By title = By.cssSelector(".title");
    private By completeText = By.cssSelector(".complete-header");


    public CheckoutCompletePage verifyCheckoutCompletePage() {

        isDisplayed(title, completeText);
        return this;

    }

    public CheckoutCompletePage getProofOfPayment() {

        checkTitle(completeText, "THANK YOU FOR YOUR ORDER");
        System.out.println("deal is done!");
        return this;

    }


}
