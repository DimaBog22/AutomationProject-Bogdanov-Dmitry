package Selenide.Moodpanda;

import Selenide.BaseTestSelenide;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;

public class AboutUsPage extends BaseTestSelenide {

    @FindBy(xpath = "//*[h2]")
    SelenideElement title;

    public AboutUsPage verifyAboutUsPage() {

        isDisplayed(title);
        return this;

    }

    public AboutUsPage printTitle() {

        getText(title);
        return this;

    }

}
