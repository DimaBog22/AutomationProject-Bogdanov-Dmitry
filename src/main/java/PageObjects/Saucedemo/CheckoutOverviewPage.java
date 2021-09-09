package PageObjects.Saucedemo;

import org.openqa.selenium.By;

public class CheckoutOverviewPage extends BasePage {

    private By title = By.cssSelector(".title");
    private By summaryPrice = By.cssSelector(".summary_total_label");
    private By finishBtn = By.id("finish");

    public CheckoutOverviewPage verifyCheckoutOverviewPage() {

        isDisplayed(title, summaryPrice, finishBtn);
        return this;

    }

    public CheckoutOverviewPage finishPayment() {

        click(finishBtn);
        return this;

    }

}
