package com.xfleet.step_definitions;

import com.xfleet.pages.DriverFilterPage;
import com.xfleet.utilities.BrowserUtils;
import com.xfleet.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;

public class FLTAPS1190 {

    DriverFilterPage driverFilterPage = new DriverFilterPage();


    //And user clicks "Driver All" drop down menu
    @And("user clicks {string} drop down")
    public void userClicksDropDown(String driverAllDropDownMenu) {
        driverFilterPage.driverAllDropDown.click();
        BrowserUtils.waitFor(6);
        System.out.println("driverAllDropDownMenu is clicked");
    }


    //When user clicks "Contains" drop down menu
    @When("user clicks {string} drop down menu button")
    public void user_clicks_drop_down_menu(String containsDropDownMenu) {
        BrowserUtils.waitFor(6);
        driverFilterPage.containsDropDown.click();
    }


    //Then list of methods should be displayed
    @Then("list of methods should be displayed")
    public void list_of_methods_should_be_displayed() {
        BrowserUtils.waitFor(6);
        driverFilterPage.listOfMethods.isDisplayed();
        System.out.println("methods are displayed ");
    }
}
