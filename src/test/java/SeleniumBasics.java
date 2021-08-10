import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class SeleniumBasics {

    WebDriver driver = null;

    @BeforeTest
    public void precondition(){

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        String link = "https://calc.by/weight-and-calories/body-mass-index-calculator.html";
        driver.get(link);

    }

    @Test(priority = 1)
    public void Test1() throws InterruptedException {

        WebElement heigth = driver.findElement(By.id("bmiVar1"));
        WebElement weight = driver.findElement(By.id("bmiVar2"));
        WebElement btn = driver.findElement(By.xpath("//*[@class='calc-btn btn-calculate']"));

        heigth.sendKeys("183");
        weight.sendKeys("58");
        btn.click();
        Thread.sleep(3000);

        WebElement answerNumber = driver.findElement(By.id("AnswerBMI")); // 17.32
        WebElement answerString = driver.findElement(By.id("AnswerBMI1")); // Недостаточной массе тела

        Assert.assertEquals(answerNumber.getText(), "17.32");
        Assert.assertEquals(answerString.getText(), "Недостаточной массе тела");

    }

    @AfterTest
    public void postcondition() {
        driver.quit();
    }

}
