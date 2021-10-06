package Selenide.Moodpanda;

import Selenide.BaseTestSelenide;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;


public class HomePage extends BaseTestSelenide {

    @FindBy(css = ".scroll-down > a")
    SelenideElement scrollDownBtn;

    @FindBy(className = "brand-name-subtext")
    SelenideElement brandNameSubtext;

    @FindBy(css = ".img-responsive.img-centered")
    SelenideElement img;

    @FindBy(xpath = "//*[text()=\"Start\"]")
    SelenideElement startBtn;

    @FindBy(css = "a[href=\"#about\"]")
    SelenideElement overviewBtn;

    @FindBy(css = "a[href=\"/about.aspx\"]")
    SelenideElement aboutBtn;

    @FindBy(css = "a[href=\"/faq.aspx\"]")
    SelenideElement faqBtn;

    public HomePage clickScrollDownBtn() {
        scrollDownBtn.click();
        return this;
    }

    public HomePage clickOverviewBtn() {
        overviewBtn.click();
        return this;
    }

    public HomePage clickAboutBtn() {
        aboutBtn.click();
        return this;
    }

    public HomePage clickFaqBtn() {
        faqBtn.click();
        return this;
    }

    public HomePage checkBrandNameSubtext() {
        brandNameSubtext.should(Condition.matchText("track your mood & get anonymous support"));
        return this;
    }

    public HomePage goToLoginPage() {
        this.startBtn.click();
        return this;
    }

    public HomePage verifyHomePage() {
        isDisplayed(img, startBtn);
        return this;
    }

}
