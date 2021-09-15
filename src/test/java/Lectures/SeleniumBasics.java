package Lectures;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.*;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class SeleniumBasics {

    WebDriver driver = null;

    @BeforeTest
    public void precondition(){

        driver = new ChromeDriver();
        driver.manage().window().maximize();

    }

    @Test(priority = 1)
    public void Test1() {

        String link = "https://calc.by/weight-and-calories/body-mass-index-calculator.html";
        driver.get(link);

        WebElement heigth = driver.findElement(By.id("bmiVar1"));
        WebElement weight = driver.findElement(By.id("bmiVar2"));
        WebElement btn = driver.findElement(By.xpath("//*[@class='calc-btn btn-calculate']"));

        heigth.sendKeys("183");
        weight.sendKeys("58");
        btn.click();

        WebElement answerNumber = driver.findElement(By.id("AnswerBMI")); // 17.32
        WebElement answerString = driver.findElement(By.id("AnswerBMI1")); // Недостаточной массе тела

        Assert.assertEquals(answerNumber.getText(), "17.32");
        Assert.assertEquals(answerString.getText(), "Недостаточной массе тела");

    }

    @Test
    public void Test2() throws InterruptedException {

        String link = "https://calc.by/building-calculators/laminate.html";
        driver.get(link);

        // working with <select></select>
        WebElement selector = driver.findElement(By.id("laying_method_laminate"));
        Select select = new Select(selector);
        select.selectByIndex(2); // с использованием отрезанного элемента



        // how to scroll the page to radio btn
        // without this step we can not see radioBtn because of adverts
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(By.id("area_room"))).perform();

        WebElement lengthRoom = driver.findElement(By.id("ln_room_id"));
        WebElement widthRoom = driver.findElement(By.id("wd_room_id"));
        WebElement lengthLaminat = driver.findElement(By.id("ln_lam_id"));
        WebElement widthLaminat = driver.findElement(By.id("wd_lam_id"));
        WebElement numberLaminat = driver.findElement(By.id("n_packing"));
        WebElement minLengthSegment = driver.findElement(By.id("min_length_segment_id"));
        WebElement intendWalls = driver.findElement(By.id("indent_walls_id"));
        WebElement radioBtn = driver.findElement(By.id("direction-laminate-id1"));
        WebElement calcBtn = driver.findElement(By.className("calc-btn"));

        // clear fields
        lengthRoom.clear();
        widthRoom.clear();
        lengthLaminat.clear();
        widthLaminat.clear();

        // set values
        lengthRoom.sendKeys("500");
        widthRoom.sendKeys("400");
        lengthLaminat.sendKeys("2000");
        widthLaminat.sendKeys("200");
        radioBtn.click();
        calcBtn.click();

        Thread.sleep(2000);

        List<String> textList = new ArrayList<String>();

        // lambda (add values to List)
        driver.findElements(By.xpath("//*[@class='calc-result']//div")).forEach((data) -> {
            textList.add(data.getText());
        });

        Assert.assertTrue(textList.contains("Требуемое количество досок ламината: 53"));
        Assert.assertTrue(textList.contains("Количество упаковок ламината: 7"));

    }

    @AfterTest
    public void postcondition() throws InterruptedException {

        Thread.sleep(3000);
        driver.quit();

    }

}
