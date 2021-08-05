import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.function.Consumer;

public class GoogleSearchTest {

    @Test
    public void Test1() throws InterruptedException {

        WebDriver driver = new ChromeDriver();
//        System.setProperty("webdriver.chrome.driver" , "D:\\TMS automation project\\AutomationProject-Bogdanov-Dmitry\\chromedriver.exe");
        // -Dwebdriver.chrome.driver=chromedriver.exe
        driver.get("https://www.google.com/");
        driver.findElement(By.name("q")).sendKeys("Hello world", Keys.ENTER);

        String s1 = driver.findElement(By.tagName("h3")).getText();
        String s2 = driver.findElement(By.xpath("(//h3)[1]")).getText();

        Assert.assertEquals(s1, "Hello, world! Карта для тех, кто летает | МТБанк");

        System.out.println(s1);
        System.out.println(s2);


        Thread.sleep(10000); // нужно добавить throws InterruptedException или обернуть в трай кэч
        driver.quit();

    }

}
