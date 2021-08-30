package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.testng.Assert;

import java.util.Locale;

import static driver.DriverCreation.getDriver;

public class BasePage {

    protected void enter(By element, CharSequence... charSequences) {
        getDriver().findElement(element).clear();
        getDriver().findElement(element).sendKeys(charSequences);
    }

    protected void click(By element) {
        getDriver().findElement(element).click();
    }

    protected void open(String url) {
        getDriver().get(url);
    }

    protected String getElementText(By element) {
        return getDriver().findElement(element).getText();
    }

    protected Integer getCountElements(By element) {
        return getDriver().findElements(element).size();
    }

    protected void isDisplayed(By... elements) {
        for (By element : elements) {
            Assert.assertTrue(getDriver().findElement(element).isDisplayed(), "Element :: " + elements + " is not exist.");
        }
    }

    protected Boolean isElementPresented(By element){

        Boolean elementCondition = false;
        try{
            elementCondition = getDriver().findElement(element).isDisplayed();
        }
        catch (NoSuchElementException e){
            return  elementCondition;
        }
        return elementCondition;

    }

    protected void checkTitle(By element, String expectedResult) {

        String actualResult = getElementText(element).toLowerCase(Locale.ROOT);
        Assert.assertEquals(actualResult, expectedResult.toLowerCase(Locale.ROOT));

    }

}