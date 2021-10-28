package CucumberTask.steps;

import driver.BaseTestSelenide;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import PageObject.Booking.HomePage;
import PageObject.Booking.SearchPage;
import static com.codeborne.selenide.Selenide.open;

public class SearchTest extends BaseTestSelenide {

    @Given("Go to {string}")
    public void openHomePage(String url) {
        open(url);

    }

    @When("Enter Krasnodar Marriott Hotel and click search button")
    public void findNecessaryHotel() {
        get(HomePage.class)
                .setName("Krasnodar Marriott Hotel")
                .clickSearchBtn();
    }

    @Then("Check that Krasnodar Marriott Hotel is displayed and have 5 stars rating")
    public void checkRating() {
        get(SearchPage.class)
                .isHotelDisplayed()
                .verifyStars();
    }

}
