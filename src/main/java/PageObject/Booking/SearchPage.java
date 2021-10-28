package PageObject.Booking;

import static com.codeborne.selenide.Selenide.$$;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.testng.Assert;

public class SearchPage {

    @FindBy(css = "[data-testid~=title]")
    SelenideElement hotel;

    ElementsCollection stars = $$(By.xpath("(//div[@data-testid='rating-stars'])[1]/span"));

    public SearchPage isHotelDisplayed(){
        Assert.assertTrue(hotel.isDisplayed());
        return this;
    }

    public SearchPage verifyStars() {
        Assert.assertEquals(stars.size(), 5);
        return this;
    }


}
