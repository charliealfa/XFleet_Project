package com.xfleet.step_definitions;

import com.xfleet.pages.DashBoardPage;
import com.xfleet.pages.LoginPage;
import com.xfleet.utilities.BrowserUtils;
import com.xfleet.utilities.ConfigurationReader;
import com.xfleet.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;

//Driver Filter
public class FLTAPS1188_SD {

    LoginPage loginPage = new LoginPage();


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
        Driver.get().findElement(By.xpath("//a[@title='Filters']")).click();
    }

    @Then("user clicks {string} drop down menu")
    public void user_clicks_drop_down_menu(String manageFiltersDropDownMenu) {
        Driver.get().findElement(By.className("add-filter-button")).click();
    }


    @Then("user clicks {string} check box")
    public void user_clicks_check_box(String driverCheckBox) {
        Driver.get().findElement(By.cssSelector("input[value='Driver']")).click();
        System.out.println("driver is clicked");
        BrowserUtils.waitFor(6);
    }
}
