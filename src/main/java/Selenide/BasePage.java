package Selenide;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import lombok.extern.log4j.Log4j2;

@Log4j2
public class BasePage extends BaseTestSelenide{

    protected void isDisplayed(SelenideElement... elements) {
        for (SelenideElement element : elements) {
            element.shouldBe(Condition.exist);
            log.info(element + " exists");
        }
    }

    protected void getText(SelenideElement element) {
        element.text();
    }

}
