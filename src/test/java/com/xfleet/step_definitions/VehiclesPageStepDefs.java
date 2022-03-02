package com.xfleet.step_definitions;

import com.xfleet.pages.DashBoardPage;
import com.xfleet.pages.VehiclesPage;
import com.xfleet.utilities.BrowserUtils;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.junit.Assert;

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

    // ESALKAN STEP DEFINITIONS ENDS HERE
}
