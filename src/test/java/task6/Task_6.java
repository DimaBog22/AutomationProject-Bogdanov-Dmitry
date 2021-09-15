package task6;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import java.util.ArrayList;
import java.util.List;

public class Task_6 {

    WebDriver driver = null;
    String link = "https://www.saucedemo.com/";

    @BeforeTest
    public void preconditions(){

        driver = new ChromeDriver();
        driver.get(link);

    }

    @Test
    public void test1() throws InterruptedException {

        // LOGIN

        // descendant:: — возвращает полное множество потомков.
        WebElement usernameField = driver.findElement(By.xpath("//*[@class='form_group']/descendant::*[@placeholder='Username']"));
        // following:: — возвращает необработанное множество, ниже текущего элемента.
        WebElement passwordField = driver.findElement(By.xpath("//*[@class='form_group']/following::*[@type='password']"));
        // Поиск по атрибуту, например By.xpath("//tag[@attribute='value']");
        WebElement loginBtn = driver.findElement(By.xpath("//input[@value='Login']"));

        WebElement rowUsernameValue = driver.findElement(By.xpath("//*[contains(text(),'standard_user')]"));
        String usernameValueStr = rowUsernameValue.getText();
        String usernameValue = getUsername(usernameValueStr);
//        System.out.println(usernameValue); // standard_user

        WebElement rowPasswordValue = driver.findElement(By.xpath("//*[contains(text(),'secret_sauce') and @class='login_password']"));
        String passwordValueStr = rowPasswordValue.getText();
        String passwordValue = getPassword(passwordValueStr);
//        System.out.println(passwordValue); // secret_sauce

        // set value to input
        setValue(usernameField, usernameValue);
        setValue(passwordField, passwordValue);
        // click button
        loginBtn.click();
        Thread.sleep(3000);

        // ADD ITEM TO THE BUCKET

        WebElement nameOfItem = driver.findElement(By.cssSelector("#item_4_title_link"));
        String nameOfItemValue = nameOfItem.getText();

        // parent:: — возвращает предка на один уровень назад.
        WebElement priceOfItem = driver.findElement(By.xpath("//*[@id='add-to-cart-sauce-labs-backpack']//parent::div"));
        String priceOfItemValueStr = priceOfItem.getText();
        String priceOfItemValue = getPrice(priceOfItemValueStr);

        WebElement addToCartBtn = driver.findElement(By.cssSelector("[data-test=add-to-cart-sauce-labs-backpack]"));
        addToCartBtn.click();
        Thread.sleep(3000);

        // IN THE BUCKET
        WebElement bucketBtn = driver.findElement(By.cssSelector(".shopping_cart_link"));
        bucketBtn.click();
        Thread.sleep(3000);

        WebElement nameOfItemInBucket = driver.findElement(By.className("inventory_item_name"));
        String nameOfItemInBucketValue = nameOfItemInBucket.getText();
        System.out.println(nameOfItemValue);
        System.out.println(nameOfItemInBucketValue);

        WebElement priceOfItemInBucket = driver.findElement(By.className("inventory_item_price"));
        String priceOfItemInBucketValue = priceOfItemInBucket.getText();
        System.out.println(priceOfItemValue);
        System.out.println(priceOfItemInBucketValue);

        // Verification

        Assert.assertEquals(nameOfItemInBucketValue, nameOfItemValue);
        Assert.assertEquals(priceOfItemInBucketValue, priceOfItemValue);


    }

    @AfterTest
    public void postconditions(){
        driver.close();
    }

    public String getUsername(String usernameValueStr){

        List<String> arrList = new ArrayList<>();
        for (String retval : usernameValueStr.split(":")) {
            arrList.add(retval);
        }

        String usernameValue = arrList.get(1).toString().substring(0, 14);
        return usernameValue;

    }

    public String getPassword(String passwordValueStr){

        List<String> arrList = new ArrayList<>();
        for (String retval : passwordValueStr.split(":")) {
            arrList.add(retval);
        }

        String passwordValue = arrList.get(1).toString();
        return passwordValue;

    }

    public String getPrice(String priceOfItemValueStr){

        List<String> arrList = new ArrayList<>();
        for (String retval : priceOfItemValueStr.split("A")) {
            arrList.add(retval);
        }

        String passwordValue = arrList.get(0).toString();
        return passwordValue.trim();

    }

    public void setValue(WebElement element, String value) {
        element.sendKeys(value);
    }

}
