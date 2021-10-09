package Selenide.Moodpanda;

import Selenide.BasePage;
import Selenide.BaseTestSelenide;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$$;

public class OverviewPage extends BasePage {

    ElementsCollection aboutElements = $$(".about-content h3");

    public OverviewPage verifyOverviewPage() {

        for (SelenideElement element: aboutElements) {
            isDisplayed(element);
        }
        return this;

    }

}
