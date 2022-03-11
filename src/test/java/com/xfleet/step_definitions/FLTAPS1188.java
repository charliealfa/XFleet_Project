package com.xfleet.step_definitions;

import com.xfleet.pages.DashBoardPage;
import com.xfleet.pages.DriverFilterPage;
import com.xfleet.pages.LoginPage;
import com.xfleet.utilities.BrowserUtils;
import com.xfleet.utilities.ConfigurationReader;
import com.xfleet.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;


public class FLTAPS1188 {

    LoginPage loginPage = new LoginPage();
    DriverFilterPage driverFilterPage = new DriverFilterPage();


    @Given("user is on the login page")
    public void user_is_on_the_login_page() {
        Driver.get().get(ConfigurationReader.get("url"));
    }


    @When("user logged with {string} {string}")
    public void user_logged_with(String driverUsername, String driverPassword) {
        loginPage.usernameInpt.sendKeys(driverUsername);
        loginPage.passwordInpt.sendKeys(driverPassword);
        loginPage.loginBtn.click();
    }


    @Then("user navigates to {string} {string}")
    public void user_navigates_to(String tab, String module) {
        BrowserUtils.waitForPageToLoad(6);
        DashBoardPage dashBoardPage = new DashBoardPage();
        dashBoardPage.navigateTo(tab, module);
        BrowserUtils.waitFor(6);
    }


    @Then("user clicks {string} icon button")
    public void user_clicks_icon_button(String filtersIconButton) {
        BrowserUtils.waitForPageToLoad(6);
        BrowserUtils.waitFor(6);
        driverFilterPage.filterIconButton.click();
    }

    @Then("user clicks {string} drop down menu")
    public void user_clicks_drop_down_menu(String manageFiltersDropDownMenu) {
        BrowserUtils.waitForPageToLoad(6);
        driverFilterPage.manageFiltersDropDown.click();
    }


    @Then("user clicks {string} check box")
    public void user_clicks_check_box(String driverCheckBox) {
        BrowserUtils.waitFor(6);
        driverFilterPage.driverCheckBox.click();
        System.out.println("driver check box is clicked");
        BrowserUtils.waitFor(6);
    }

}
