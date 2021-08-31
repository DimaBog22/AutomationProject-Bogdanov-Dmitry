package task8;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Task_8 {

    WebDriver driver = null;
    String link = "D:\\TMS automation project\\AutomationProject-Bogdanov-Dmitry\\src\\test\\java\\task8\\contacts.html";

    @BeforeTest
    public void preconditions() {

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(link);

    }

    @Test
    public void test1() throws InterruptedException {

        // web elements
        WebElement submitBtn = driver.findElement(By.cssSelector("input[type='submit']"));
        WebElement select = driver.findElement(By.tagName("select"));
        Select optionRegion = new Select(select);
        WebElement deliveryсheckbox = driver.findElement(By.cssSelector("input[type='checkbox']"));
        WebElement inputName = driver.findElement(By.xpath("//*[@placeholder=\"Укажите ваше имя!\"]"));
        WebElement inputEmail = driver.findElement(By.xpath("//*[@type=\"email\"]"));
        WebElement textarea = driver.findElement(By.tagName("textarea"));
        // actions
        optionRegion.selectByIndex(1);
        deliveryсheckbox.click();
        inputName.sendKeys("Dima");
        inputEmail.sendKeys("bogdanov111222@yandex.ru");
        textarea.sendKeys("I want to by something");
        Thread.sleep(3000);
        submitBtn.click();
        // explicit expectation
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("[alt='Спецтехника из Японии']")));
        WebElement img = driver.findElement(By.cssSelector("[alt='Спецтехника из Японии']"));
        // working with the table
        List<String> textList = new ArrayList<String>();
        // lambda (add values to List)
        driver.findElements(By.cssSelector(".forArrayList")).forEach((data) -> {
            textList.add(data.getText());
        });
        for (String item : textList) {
            System.out.println(item);
        }
        // verifications
        Thread.sleep(3000);
        Assert.assertTrue(img.isDisplayed());

    }

    @Test
    public void test2() throws InterruptedException {

        // web elements
        WebElement addres = driver.findElement(By.cssSelector(".address")); // <p>
        System.out.println(addres.getText());
        // verifications
        Thread.sleep(3000);
        Assert.assertEquals(addres.getText(), "Минская область, г.Раков");

    }

    @Test
    public void test3() throws InterruptedException {

        // web elements
        WebElement vkLink = driver.findElement(By.linkText("VK")); // <a>
        // verifications
        vkLink.click();
        Thread.sleep(3000);
        WebElement logoOnVK = driver.findElement(By.cssSelector("[aria-label='На главную']"));
        Assert.assertTrue(logoOnVK.isDisplayed());

    }

    @AfterTest
    public void postconditions() {
        driver.close();
    }

}

