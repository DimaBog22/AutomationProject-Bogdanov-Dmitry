package Lectures.Herokuapp;

import PageObjects.Herokuapp.ContextMenuObject;
import PageObjects.Herokuapp.DynamicControlsObject;
import PageObjects.Herokuapp.HomePageObject;
import driver.BaseTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static PageObjects.Herokuapp.HomePageLinksEnum.CONTEXT_MENU;

public class ContextMenu_Test extends BaseTest{

    ContextMenuObject contextMenuObject;
    HomePageObject homePageObject;

    @BeforeClass
    public void precondition() {

        contextMenuObject = new ContextMenuObject();
        homePageObject = new HomePageObject();
        homePageObject.clickLink(CONTEXT_MENU);

    }

    @Test
    public void contextMenuObject_Test() {

        contextMenuObject
                .verifyPageTitle()
                .verifyAlertText();
    }

}
