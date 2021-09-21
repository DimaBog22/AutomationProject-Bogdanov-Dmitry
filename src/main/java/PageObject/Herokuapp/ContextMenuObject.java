package PageObject.Herokuapp;

import PageObject.Saucedemo.BasePage;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import static driver.DriverCreation.getDriver;
import static PageObject.Herokuapp.HomePageLinksEnum.CONTEXT_MENU;

public class ContextMenuObject extends BasePage {

    private By title = By.tagName("h3");
    private By hotSpot = By.id("hot-spot");
    Actions actions = new Actions(getDriver());

    public ContextMenuObject verifyPageTitle() {

        Assert.assertEquals(getElementText(title), CONTEXT_MENU.getLinkText());
        return this;

    }

    public ContextMenuObject verifyAlertText(){

        actions.contextClick(getDriver().findElement(hotSpot)).perform();
        Alert alert = getDriver().switchTo().alert();
        Assert.assertEquals(alert.getText(), "You selected a context menu");
        alert.accept();
        return this;

    }

}