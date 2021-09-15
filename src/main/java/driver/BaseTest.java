package driver;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import testNG.Listener;

import static driver.DriverCreation.getDriver;
import static driver.DriverCreation.quitDriver;

@Listeners(Listener.class)
public class BaseTest {
    public WebDriver driver;

    @BeforeTest
    public void setupDriver() {
        driver = getDriver();
    }

    @AfterTest
    public void closeDriver() {
        quitDriver();
    }
}