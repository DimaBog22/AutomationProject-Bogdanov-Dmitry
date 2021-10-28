package driver;

import lombok.extern.log4j.Log4j2;
import org.testng.annotations.Listeners;
import testNG.Listener;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.page;
import static com.codeborne.selenide.WebDriverRunner.driver;
@Log4j2
@Listeners(Listener.class)
public class BaseTestSelenide {

    String link = "https://www.booking.com/";

    protected <PageObjectClass> PageObjectClass get(Class<PageObjectClass> pageObjectClassClass) {
        log.info(link + " is using");
        return driver().hasWebDriverStarted() ? page(pageObjectClassClass) : open(link, pageObjectClassClass);
    }
}
