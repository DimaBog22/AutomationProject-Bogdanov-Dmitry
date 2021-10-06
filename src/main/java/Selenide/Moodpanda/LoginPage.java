package Selenide.Moodpanda;

import Selenide.BaseTestSelenide;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.support.FindBy;
@Log4j2
public class LoginPage extends BaseTestSelenide {

    @FindBy(css = "#UpdateMoodWelcome .modal-header h4")
    SelenideElement loginPageTitle;

    @FindBy(name = "ctl00$ContentPlaceHolderContent$TextBoxEmail")
    SelenideElement emailInput;

    @FindBy(name = "ctl00$ContentPlaceHolderContent$TextBoxPassword")
    SelenideElement passwordInput;

    public LoginPage checkLoginPageTitleText() {

        loginPageTitle.should(Condition.matchText("Login to MoodPanda"));
        log.info(loginPageTitle.text());
        return this;

    }

    public LoginPage verifyLoginPage() {

        isDisplayed(loginPageTitle, emailInput, passwordInput);
        return this;

    }

}
