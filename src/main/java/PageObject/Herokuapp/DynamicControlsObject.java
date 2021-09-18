package PageObject.Herokuapp;

import PageObject.Saucedemo.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.testng.Assert;
import java.util.function.Function;
import static driver.DriverCreation.getDriver;
import static PageObject.Herokuapp.HomePageLinksEnum.DYNAMIC_CONTROLS;

public class DynamicControlsObject extends BasePage {

    private By removeBtn = By.cssSelector("#checkbox-example>button");
    private By textBack = By.cssSelector("#checkbox-example>p");
    private By title = By.tagName("h4");
    private By checkbox = By.id("checkbox");
    private By inputText = By.xpath("//input[@type=\"text\"]");
    private By inputTextEnableBtn = By.xpath("//button[text()='Enable']");
    private By itsEnabledMessage = By.id("message");

    Wait wait = new Wait() {

        @Override
        public Object until(Function function) {
            return null;
        }

    };

    public DynamicControlsObject verifyPageTitle() {

        Assert.assertEquals(getElementText(title), DYNAMIC_CONTROLS.getLinkText());
        return this;

    }

    public DynamicControlsObject clickRemoveBtn() {

        click(removeBtn);
        return this;

    }

    public DynamicControlsObject clickinputTextEnableBtn() {

        click(inputTextEnableBtn);
        return this;

    }

    public DynamicControlsObject verifyElementText(String text) {

        wait.until(ExpectedConditions.textToBe(textBack, text));
        return this;

    }

    public DynamicControlsObject checkCheckboxIsAbsent() {

        wait.until(ExpectedConditions.invisibilityOf(getDriver().findElement(checkbox)));
        System.out.println("checkCheckboxIsAbsent");
        return this;

    }

    public DynamicControlsObject sleep() {

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return this;

    }

    public DynamicControlsObject checkInputIsDisabled() {

        Assert.assertFalse(getDriver().findElement(inputText).isEnabled());
        System.out.println("InputIsDisabled");
        return this;

    }

    public DynamicControlsObject checkItsEnabledText() {

        String expectedResult = "It's enabled!";
        wait.until(ExpectedConditions.visibilityOf(getDriver().findElement(itsEnabledMessage)));
        Assert.assertEquals(getDriver().findElement(itsEnabledMessage).getText(), expectedResult);
        System.out.println(expectedResult);
        return this;

    }

    public DynamicControlsObject checkInputIsEnabled() {

        Assert.assertTrue(getDriver().findElement(inputText).isEnabled());
        System.out.println("InputIsEnabled");
        return this;

    }

}