package PageObjects;

import org.openqa.selenium.By;
import org.testng.Assert;

import java.util.Locale;

public class CheckoutCompletePage extends BasePage {

    private By title = By.cssSelector(".title");
    private By completeText = By.cssSelector(".complete-header");


    public CheckoutCompletePage verifyCheckoutCompletePage() {

        isDisplayed(title, completeText);
        return this;

    }

    public CheckoutCompletePage getProofOfPayment() {

        String actualResult = getElementText(completeText).toLowerCase(Locale.ROOT);
        Assert.assertEquals(actualResult, "THANK YOU FOR YOUR ORDER".toLowerCase(Locale.ROOT));
        System.out.println(actualResult);
        return this;

    }


}
