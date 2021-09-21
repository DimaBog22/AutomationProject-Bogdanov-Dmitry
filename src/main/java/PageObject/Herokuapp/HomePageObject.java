package PageObject.Herokuapp;

import PageObject.Saucedemo.BasePage;
import org.openqa.selenium.By;

import java.util.Arrays;

public class HomePageObject extends BasePage {

    private By title = By.tagName("h1");
    private By subTitle = By.tagName("h2");

    private By getLink(HomePageLinksEnum homePageLinksEnum) {
        return By.linkText(homePageLinksEnum.getLinkText());
    }

    private By getLink(String homePageLinksEnum) {
        return By.linkText(homePageLinksEnum);
    }

    public HomePageObject open() {

        open("http://the-internet.herokuapp.com/");
        return this;

    }

    public HomePageObject verifyHomePage() {

        isDisplayed(title, subTitle);
        Arrays.asList(HomePageLinksEnum.values()).forEach(homePageLinksEnum -> isDisplayed(getLink(homePageLinksEnum)));
        return this;

    }

    public HomePageObject clickLink(HomePageLinksEnum homePageLinksEnum) {

        click(getLink(homePageLinksEnum));
        return this;

    }

    public HomePageObject clickLink(String homePageLinksEnum) {

        click(getLink(homePageLinksEnum));
        return this;

    }

}