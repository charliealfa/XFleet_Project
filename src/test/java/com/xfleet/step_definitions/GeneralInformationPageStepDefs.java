package com.xfleet.step_definitions;

import com.xfleet.pages.GeneralInformationPage;
import com.xfleet.pages.VehiclesPage;
import com.xfleet.utilities.BrowserUtils;
import com.xfleet.utilities.Driver;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.interactions.Actions;

public class GeneralInformationPageStepDefs {

    GeneralInformationPage generalInformationPage = new GeneralInformationPage();
    VehiclesPage vehiclesPage = new VehiclesPage();
    Actions actions = new Actions(Driver.get());

    @Then("user should be on General Information page")
    public void user_should_be_on_General_Information_page() {
        Assert.assertEquals("Header is not as expected","General Information",generalInformationPage.generalInformationHeader.getText());
    }

    @When("user clicks Eye icon to navigate to General Information page")
    public void user_clicks_Eye_icon_to_navigate_to_General_Information_page() {
        BrowserUtils.waitForPageToLoad(10);
        actions.moveToElement(vehiclesPage.anyThreeDot).perform();
        BrowserUtils.waitFor(1);
        vehiclesPage.eyeIcon.click();
    }

    @Then("user should see Edit, Delete and Add Event buttons")
    public void user_should_see_Edit_Delete_and_Add_Event_buttons() {
        Assert.assertTrue("Edit button is not displayed",generalInformationPage.editButton.isDisplayed());
        Assert.assertTrue("Delete button is not displayed",generalInformationPage.deleteButton.isDisplayed());
        Assert.assertTrue("Add Event button is not displayed",generalInformationPage.addEventButton.isDisplayed());
    }

}
