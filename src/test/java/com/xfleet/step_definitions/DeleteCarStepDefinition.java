package com.xfleet.step_definitions;

import com.xfleet.pages.DashBoardPage;
import com.xfleet.pages.VehiclesPage;
import com.xfleet.utilities.BrowserUtils;
import com.xfleet.utilities.Driver;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.interactions.Actions;

public class DeleteCarStepDefinition {

    DashBoardPage dashBoardPage = new DashBoardPage();
    VehiclesPage vehiclePage = new VehiclesPage();
    Actions actions = new Actions(Driver.get());

    @When("the user clicks Fleet,Vehicles module")
    public void the_user_clicks_Fleet_Vehicles_module() {
        DashBoardPage dashBoardPage = new DashBoardPage();
        dashBoardPage.navigateTo("Fleet","Vehicles");
    }

    @When("the user clicks three dot button")
    public void the_user_clicks_three_dot_button() {
        actions.moveToElement(vehiclePage.anyThreeDot).perform();
        BrowserUtils.waitFor(3);
    }

    @Then("the user can see delete feature")
    public void the_user_can_see_delete_feature() {
        vehiclePage.eyeIcon.isDisplayed();
        vehiclePage.logOut();
    }

    @When("the user clicks delete button")
    public void the_user_clicks_delete_button() {
        //((JavascriptExecutor) Driver.get()).executeScript("arguments[0].click();", vehiclePage.deleteBtn);
        vehiclePage.eyeIcon.click();
    }

    @Then("the user should see {string} pop up")
    public void the_user_should_see_pop_up(String string) {

    }


}
