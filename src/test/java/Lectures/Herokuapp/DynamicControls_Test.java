package Lectures.Herokuapp;

import PageObjects.Herokuapp.DynamicControlsObject;
import PageObjects.Herokuapp.HomePageObject;
import driver.BaseTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import static PageObjects.Herokuapp.HomePageLinksEnum.DYNAMIC_CONTROLS;


public class DynamicControls_Test extends BaseTest{

    DynamicControlsObject dynamicControlsObject;
    HomePageObject homePageObject;

    @BeforeClass
    public void precondition() {

        dynamicControlsObject = new DynamicControlsObject();
        homePageObject = new HomePageObject();

        homePageObject.
                clickLink(DYNAMIC_CONTROLS);

    }

    @Test
    public void dynamicControlsObject_Test() {

        dynamicControlsObject.
                verifyPageTitle()
                .clickRemoveBtn()
                .verifyElementText("It's gone!")
                .checkCheckboxIsAbsent()
                .sleep()
                .checkInputIsDisabled()
                .sleep()
                .clickinputTextEnableBtn()
                .checkItsEnabledText()
                .sleep()
                .checkInputIsEnabled();

    }

}
