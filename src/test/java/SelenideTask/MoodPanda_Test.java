package SelenideTask;

import Selenide.Moodpanda.*;
import Selenide.BaseTestSelenide;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import static com.codeborne.selenide.Selenide.closeWebDriver;

public class MoodPanda_Test extends BaseTestSelenide {

    @Test
    public void verifyHomePage_Test() {

        get(HomePage.class)
                .checkBrandNameSubtext()
                .verifyHomePage();

    }

    @Test
    public void verifyTestimonialsPage_Test() {

        get(HomePage.class)
                .clickScrollDownBtn();

        get(TestimonialsPage.class)
                .verifyContentText("FOR MOOD-TRACKING")
                .verifyContentText("MOBILE & WEB APP");

    }

    @Test
    public void verifyLoginPage_Test() {

        get(HomePage.class)
                .verifyHomePage()
                .goToLoginPage();

        get(LoginPage.class)
                .verifyLoginPage()
                .checkLoginPageTitleText();

    }

    @Test
    public void verifyOverviewPage_Test() {

        get(HomePage.class)
                .verifyHomePage()
                .clickOverviewBtn();

        get(OverviewPage.class)
                .verifyOverviewPage();

    }

    @Test
    public void verifyAboutUsPage_Test() {

        get(HomePage.class)
                .verifyHomePage()
                .clickAboutBtn();

        get(AboutUsPage.class)
                .verifyAboutUsPage()
                .printTitle();

    }

    @Test
    public void verifyFaqPage_Test() {

        get(HomePage.class)
                .verifyHomePage()
                .clickFaqBtn();

        get(FaqPage.class)
                .verifyFaqPage();

    }

    @AfterMethod
    public void post() {
        closeWebDriver();
    }

}
