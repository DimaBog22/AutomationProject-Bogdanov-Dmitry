package task5;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Task_5 {

    WebDriver driver = null;

    @BeforeTest
    public void preconditions(){

        driver = new ChromeDriver();
        String link = "https://masterskayapola.ru/kalkulyator/laminata.html";
        driver.get(link);

    }

    @Test
    public void test1() throws InterruptedException {

        WebElement roomWidth = driver.findElement(By.name("calc_roomwidth"));
        roomWidth.sendKeys(Keys.LEFT_CONTROL + "a", Keys.BACK_SPACE);
        roomWidth.sendKeys("10");

        WebElement roomHeight = driver.findElement(By.name("calc_roomheight"));
        roomHeight.sendKeys(Keys.LEFT_CONTROL + "a", Keys.BACK_SPACE);
        roomHeight.sendKeys("10");

        WebElement lamWidth = driver.findElement(By.name("calc_lamwidth"));
        lamWidth.sendKeys(Keys.LEFT_CONTROL + "a", Keys.BACK_SPACE);
        lamWidth.sendKeys("110");

        WebElement lamHeight = driver.findElement(By.name("calc_lamheight"));
        lamHeight.sendKeys(Keys.LEFT_CONTROL + "a", Keys.BACK_SPACE);
        lamHeight.sendKeys("55");

        WebElement inPack = driver.findElement(By.name("calc_inpack"));
        inPack.sendKeys(Keys.LEFT_CONTROL + "a", Keys.BACK_SPACE);
        inPack.sendKeys("10");

        WebElement price = driver.findElement(By.name("calc_price"));
        price.sendKeys(Keys.LEFT_CONTROL + "a", Keys.BACK_SPACE);
        price.sendKeys("55");

        // working with <select>
        WebElement selector = driver.findElement(By.name("calc_direct"));
        Select select = new Select(selector);
        select.selectByIndex(1); // По ширине комнаты

        WebElement bias = driver.findElement(By.name("calc_bias"));
        bias.sendKeys(Keys.LEFT_CONTROL + "a", Keys.BACK_SPACE);
        bias.sendKeys("10");

        WebElement walldist = driver.findElement(By.name("calc_walldist"));
        walldist.sendKeys(Keys.LEFT_CONTROL + "a", Keys.BACK_SPACE);
        walldist.sendKeys("10");

        WebElement btn = driver.findElement(By.cssSelector(".btn-secondary"));
        btn.click();

        Thread.sleep(10000);

        WebElement countOfPanels = driver.findElement(By.id("l_count"));
        WebElement resultPrice = driver.findElement(By.id("l_price"));

        String countOfPanelsValue = countOfPanels.getText();
        String resultPriceValue = resultPrice.getText();

        Assert.assertEquals(countOfPanelsValue, "16562 шт.");
        Assert.assertEquals(resultPriceValue, "5513 руб.");

    }

    @Test
    public void test2() throws InterruptedException {

        WebElement roomWidth = driver.findElement(By.name("calc_roomwidth"));
        roomWidth.sendKeys(Keys.LEFT_CONTROL + "a", Keys.BACK_SPACE);
        roomWidth.sendKeys("11");

        WebElement roomHeight = driver.findElement(By.name("calc_roomheight"));
        roomHeight.sendKeys(Keys.LEFT_CONTROL + "a", Keys.BACK_SPACE);
        roomHeight.sendKeys("10");

        WebElement lamWidth = driver.findElement(By.name("calc_lamwidth"));
        lamWidth.sendKeys(Keys.LEFT_CONTROL + "a", Keys.BACK_SPACE);
        lamWidth.sendKeys("111");

        WebElement lamHeight = driver.findElement(By.name("calc_lamheight"));
        lamHeight.sendKeys(Keys.LEFT_CONTROL + "a", Keys.BACK_SPACE);
        lamHeight.sendKeys("56");

        WebElement inPack = driver.findElement(By.name("calc_inpack"));
        inPack.sendKeys(Keys.LEFT_CONTROL + "a", Keys.BACK_SPACE);
        inPack.sendKeys("11");

        WebElement price = driver.findElement(By.name("calc_price"));
        price.sendKeys(Keys.LEFT_CONTROL + "a", Keys.BACK_SPACE);
        price.sendKeys("56");

        // working with <select>
        WebElement selector = driver.findElement(By.name("calc_direct"));
        Select select = new Select(selector);
        select.selectByIndex(1); // По ширине комнаты

        WebElement bias = driver.findElement(By.name("calc_bias"));
        bias.sendKeys(Keys.LEFT_CONTROL + "a", Keys.BACK_SPACE);
        bias.sendKeys("11");

        WebElement walldist = driver.findElement(By.name("calc_walldist"));
        walldist.sendKeys(Keys.LEFT_CONTROL + "a", Keys.BACK_SPACE);
        walldist.sendKeys("11");

        WebElement btn = driver.findElement(By.cssSelector(".btn-secondary"));
        btn.click();

        Thread.sleep(10000);

        WebElement countOfPanels = driver.findElement(By.id("l_count"));
        WebElement resultPrice = driver.findElement(By.id("l_price"));

        String countOfPanelsValue = countOfPanels.getText();
        String resultPriceValue = resultPrice.getText();

        Assert.assertEquals(countOfPanelsValue, "17640 шт.");
        Assert.assertEquals(resultPriceValue, "6141 руб.");

    }

    @Test
    public void test3() throws InterruptedException {

        WebElement roomWidth = driver.findElement(By.name("calc_roomwidth"));
        roomWidth.sendKeys(Keys.LEFT_CONTROL + "a", Keys.BACK_SPACE);
        roomWidth.sendKeys("11");

        WebElement roomHeight = driver.findElement(By.name("calc_roomheight"));
        roomHeight.sendKeys(Keys.LEFT_CONTROL + "a", Keys.BACK_SPACE);
        roomHeight.sendKeys("10");

        WebElement lamWidth = driver.findElement(By.name("calc_lamwidth"));
        lamWidth.sendKeys(Keys.LEFT_CONTROL + "a", Keys.BACK_SPACE);
        lamWidth.sendKeys("111");

        WebElement lamHeight = driver.findElement(By.name("calc_lamheight"));
        lamHeight.sendKeys(Keys.LEFT_CONTROL + "a", Keys.BACK_SPACE);
        lamHeight.sendKeys("56");

        WebElement inPack = driver.findElement(By.name("calc_inpack"));
        inPack.sendKeys(Keys.LEFT_CONTROL + "a", Keys.BACK_SPACE);
        inPack.sendKeys("11");

        WebElement price = driver.findElement(By.name("calc_price"));
        price.sendKeys(Keys.LEFT_CONTROL + "a", Keys.BACK_SPACE);
        price.sendKeys("56");

        // working with <select>
        WebElement selector = driver.findElement(By.name("calc_direct"));
        Select select = new Select(selector);
        select.selectByIndex(0); // По длине комнаты

        WebElement bias = driver.findElement(By.name("calc_bias"));
        bias.sendKeys(Keys.LEFT_CONTROL + "a", Keys.BACK_SPACE);
        bias.sendKeys("11");

        WebElement walldist = driver.findElement(By.name("calc_walldist"));
        walldist.sendKeys(Keys.LEFT_CONTROL + "a", Keys.BACK_SPACE);
        walldist.sendKeys("11");

        WebElement btn = driver.findElement(By.cssSelector(".btn-secondary"));
        btn.click();

        Thread.sleep(10000);

        WebElement countOfPanels = driver.findElement(By.id("l_count"));
        WebElement resultPrice = driver.findElement(By.id("l_price"));
        WebElement lamSq = driver.findElement(By.id("s_lam"));

        String countOfPanelsValue = countOfPanels.getText();
        String resultPriceValue = resultPrice.getText();
        String lamSqValue = lamSq.getText();

        Assert.assertEquals(countOfPanelsValue, "17721 шт.");
        Assert.assertEquals(resultPriceValue, "6168 руб.");
        Assert.assertEquals(lamSqValue, "109.54 м2.");

    }

    @AfterTest
    public void postconditions() {
        driver.close();
    }

}
