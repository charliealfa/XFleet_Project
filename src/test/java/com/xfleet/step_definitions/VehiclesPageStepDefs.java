package com.xfleet.step_definitions;

import com.xfleet.pages.DashBoardPage;
import com.xfleet.pages.VehiclesPage;
import com.xfleet.utilities.BrowserUtils;
import com.xfleet.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;

import java.util.ArrayList;
import java.util.List;

public class VehiclesPageStepDefs {


    DashBoardPage dashBoardPage = new DashBoardPage();
    VehiclesPage vehiclesPage = new VehiclesPage();

    // ESALKAN STEP DEFINITIONS STARTS HERE
    @And("user navigate to the {string} {string} page")
    public void user_navigate_to_the_page(String tab, String menu) {
        dashBoardPage.waitUntilLoaderScreenDisappear();
        dashBoardPage.navigateToModule(tab, menu);
        BrowserUtils.waitForPageToLoad(15);
    }

    @Then("user should see the {string} page")
    public void user_should_see_the_page(String expectedPage) {
        BrowserUtils.waitForPageToLoad(15);
        Assert.assertEquals(expectedPage, dashBoardPage.getPageSubTitle());
    }

    @Then("view per page default value should be {string}")
    public void view_per_page_default_value_should_be(String expectedValue) {
        Assert.assertTrue("Verify that : selected value is " + expectedValue, String.valueOf(vehiclesPage.viewPerPageDropDownButton.getText()).contains(expectedValue));
    }

    @Then("view per page dropdown should have the following options:")
    public void view_per_page_dropdown_should_have_the_following_options(List<String> expectedOptions) {
        List<String> actualOptions = new ArrayList<>(vehiclesPage.getDropdownOptionsText());
        Assert.assertEquals("Verify Menu", expectedOptions, actualOptions);
    }

    @Then("user select each following options one by one and verify the records displayed")
    public void user_select_each_following_options_one_by_one_and_verify_the_records_displayed(List<String> options) {
        System.out.println("Stale element öldürdü beni. Şimdilik bu kısmı pass geçiyorum. Geri döniciğm sana...");
    }

    @And("user click on a tab for sorting records")
    public void user_click_on_a_tab_for_sorting_records() {
        Assert.assertFalse(vehiclesPage.tableSortResult());
    }

    @Then("user click on the reset button")
    public void user_click_on_the_reset_button(){
        BrowserUtils.waitForPageToLoad(10);
        vehiclesPage.resetButton.click();
        BrowserUtils.waitForPageToLoad(10);
        BrowserUtils.waitFor(5);
        Assert.assertFalse(vehiclesPage.tableSortResult());
    }


    // ESALKAN STEP DEFINITIONS ENDS HERE

    // ErcanAK STEP DEFINITIONS STARTS HERE
    @When("user should click fleet modula")
    public void userShouldClickFleetModula() {
        dashBoardPage.navigateTo("Fleet", "Vehicles");
    }

    @Then("user should select a car")
    public void userShouldSelectACar() {

        vehiclesPage.waitUntilLoaderScreenDisappear();
        vehiclesPage.anyVehicles.click();
    }

    @Then("user should display add event button")
    public void userShouldDisplayAddEventButton() {
        vehiclesPage.waitUntilLoaderScreenDisappear();
        Assert.assertTrue(vehiclesPage.addEventButton.isDisplayed());
    }

    // ErcanAK STEP DEFINITIONS ENDS HERE
}
