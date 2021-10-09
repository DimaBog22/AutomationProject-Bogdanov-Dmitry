package Selenide;


import lombok.extern.log4j.Log4j2;
import properties.PropertyReader;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.page;
import static com.codeborne.selenide.WebDriverRunner.driver;
@Log4j2

public class BaseTestSelenide {

    PropertyReader appProperties = new PropertyReader("config/config.properties");
    String link = appProperties.getProperties().getProperty("moodPandaUrl");

    protected <PageObjectClass> PageObjectClass get(Class<PageObjectClass> pageObjectClassClass) {
        log.info(link + " is using");
        return driver().hasWebDriverStarted() ? page(pageObjectClassClass) : open(link, pageObjectClassClass);
    }


}
