package task5;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.*;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class Task_5_2 {

    WebDriver driver = null;

    @BeforeMethod
    public void preconditions() {

        driver = new ChromeDriver();
        String link = "https://www.google.com/";
        driver.get(link);

    }

    @Test
    public void test1() throws InterruptedException {

        String inputData = "Привет мир";
        WebElement searchInput = driver.findElement(By.name("q"));
        searchInput.sendKeys(inputData, Keys.ENTER);

        List<String> textList = new ArrayList<String>();

        // lambda (add values to List)
        driver.findElements(By.xpath("//*[@class='LC20lb DKV0Md']")).forEach((data) -> {
            textList.add(data.getText());
        });

//        for (String item : textList) {
//            System.out.println(item);
//        }

        // last element of list
        String textOfLastLink = textList.get(textList.size() - 1);
        System.out.println(textOfLastLink);

        WebElement lastLink = driver.findElement(By.partialLinkText(textOfLastLink));
        Actions actions = new Actions(driver);
        actions.moveToElement(lastLink);
        Thread.sleep(3000);
        lastLink.click();

        WebElement newPage = driver.findElement(By.xpath("//body"));
        boolean newPageisDisplayed = newPage.isDisplayed();

        Assert.assertTrue(newPageisDisplayed);

    }

    @Test
    public void test2() {

        String inputData = "//";
        WebElement searchInput = driver.findElement(By.name("q"));
        searchInput.sendKeys(inputData, Keys.ENTER);

        String actualResult = driver.findElement(By.xpath("//p[1]")).getText();
        String expectedResult = "По запросу // ничего не найдено. ";
        System.out.println(actualResult);
        Assert.assertEquals(actualResult, expectedResult);

    }

    @AfterMethod
    public void postconditions() {
        driver.close();
    }

}
