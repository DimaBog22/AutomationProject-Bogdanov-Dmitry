import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Iterator;
import java.util.List;
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

        Thread.sleep(3000); // нужно добавить throws InterruptedException или обернуть в трай кэч
        driver.quit();

    }

    @Test
    public void Test2() throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        String link = "https://www.google.com/";
        String helloWorld = "Привет мир";
        String h3Content = "";
        boolean result = true;

        driver.get(link);
        driver.findElement(By.name("q")).sendKeys(helloWorld, Keys.ENTER);

        List<WebElement> links = driver.findElements(By.tagName("h3"));
        Iterator<WebElement> it = links.iterator();

        int i = 0;
        while(it.hasNext()) {

            h3Content = it.next().getText();
            System.out.println(h3Content);

            if (h3Content.contains(helloWorld)) {
                result = true;
            } else {
                result = false;
            }
        }

        System.out.println(result);

        Assert.assertFalse(result);

        Thread.sleep(3000);
        driver.quit();

    }

}
