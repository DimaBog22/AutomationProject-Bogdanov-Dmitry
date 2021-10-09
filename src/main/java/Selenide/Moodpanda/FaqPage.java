package Selenide.Moodpanda;

import Selenide.BasePage;
import Selenide.BaseTestSelenide;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;

public class FaqPage extends BasePage {

    @FindBy(tagName = "h2")
    SelenideElement title;

    public FaqPage verifyFaqPage() {

        isDisplayed(title);
        return this;

    }


}
