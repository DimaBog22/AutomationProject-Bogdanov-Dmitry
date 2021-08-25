import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Task_7 {

    WebDriver driver = null;
    String link = "file:///D:/QA-%20automation%20%D0%BA%D1%83%D1%80%D1%81/%D0%B4%D0%B7%20%D0%BF%D0%BE%20%D0%B2%D0%B5%D1%80%D1%81%D1%82%D0%BA%D0%B5/contacts.html";

    @BeforeTest
    public void preconditions(){

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(link);

    }

    @Test
    public void test1() throws InterruptedException {

        // web elements
        WebElement vkLink = driver.findElement(By.linkText("VK")); // <a>
        WebElement addres = driver.findElement(By.cssSelector(".address")); // <p>
        WebElement backgroundImg = driver.findElement(By.cssSelector("[alt='Спецтехника из Японии']")); //<img>
        WebElement submitBtn = driver.findElement(By.cssSelector("input[type='submit']"));
//        System.out.println(submitBtn.getAttribute("value")); // тк отправить - не текст, а значение атрибута value
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

        Assert.assertTrue(backgroundImg.isDisplayed());




    }

}
