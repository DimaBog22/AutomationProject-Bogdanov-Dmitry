package PageObjectLesson;

import PageFactory.LoginPage;
import composition.Person;
import driver.DriverExecutor;
import inheritance.IHand;
import inheritance.IPerson;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class PageObjectTrain extends DriverExecutor {
    PageObjects.LoginPage loginPage;
    LoginPage loginPageAnnotations;

    @BeforeTest
    public void preconditions() {
        loginPage = new PageObjects.LoginPage(driver);
        loginPageAnnotations = new LoginPage(driver);
    }

    //@Test
    public void test1() {
        loginPage
                .openPage()
                .clickLoginBtn()
                .fillAuthFields("123", "123")
                .enterLogin("123")
                .enterPassword("123")
                .clickLoginBtn();
    }

    // @Test
    public void test2() {
        loginPageAnnotations
                .openPage()
                .fillAuthFields("123", "123");
    }

    @Test
    public void test3 () {
        Person person = new Person();
        System.out.println(person.getFingers());
        IPerson iPerson = new IPerson();
        IHand ihand = new IHand();
        ihand.getName();
    }
}