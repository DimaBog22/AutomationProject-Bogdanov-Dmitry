package PageObjects.Saucedemo;

import org.openqa.selenium.By;
import org.testng.Assert;
import properties.PropertyReader;
import java.util.Locale;
import static driver.DriverCreation.getDriver;

public class BasePage {

    protected PropertyReader appProperties;

    public BasePage() {
        appProperties = new PropertyReader("config/config.properties");
    }

    protected void enter(By element, CharSequence... charSequences) {
        getDriver().findElement(element).clear();
        getDriver().findElement(element).sendKeys(charSequences);
    }

    protected void click(By element) {
        getDriver().findElement(element).click();
    }

    protected void openLink(String url) {
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

        if(getDriver().findElements(element).size() != 0) {
            return true;
        }
        return false;

    }

    protected void checkTitle(By element, String expectedResult) {

        String actualResult = getElementText(element).toLowerCase(Locale.ROOT);
        Assert.assertEquals(actualResult, expectedResult.toLowerCase(Locale.ROOT));

    }
    // using config.properties file
    protected void openLink() {
        getDriver().get(appProperties.getProperties().getProperty("url"));
    }

    protected void open(String url) {
        getDriver().get(url);
    }

}