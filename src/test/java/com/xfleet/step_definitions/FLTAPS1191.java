package com.xfleet.step_definitions;

import com.xfleet.pages.DriverFilterPage;
import com.xfleet.utilities.BrowserUtils;
import com.xfleet.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class FLTAPS1191 {

    DriverFilterPage driverFilterPage = new DriverFilterPage();

    /*@Given("user inputs {string} keyword into text box")
    public void user_inputs_keyword_into_text_box(String keyword) {
        BrowserUtils.waitFor(6);
        *//*driverFilterPage.containsTextBox.sendKeys(keyword);
        System.out.println("keyword is keyed in");*//*

        JavascriptExecutor jse = (JavascriptExecutor) Driver.get();
        jse.executeScript("arguments[0].value='Miss'", driverFilterPage.containsTextBox);
    }*/


    /*@Given("user inputs keyword into text box")
    public void userInputsKeywordIntoTextBox() {
        BrowserUtils.waitFor(6);
        driverFilterPage.containsMethod.click();
        BrowserUtils.waitFor(6);
        JavascriptExecutor jse = (JavascriptExecutor) Driver.get();
        jse.executeScript("arguments[0].setAttribute('value', '" + "Miss" +"')", driverFilterPage.containsTextBox);
        BrowserUtils.waitFor(6);
    }*/




    @Given("user clicks methodsList drop down menu list")
    public void userClicksMethodsListDropDownMenuList() {
        driverFilterPage.clickMethodsByIndex();
    }






    @When("user clicks {string} button")
    public void user_clicks_button(String updateButton) {
        driverFilterPage.updateButton.click();
        System.out.println("button is clicked");
    }





    @Then("results with {string} are displayed only")
    public void results_with_are_displayed_only(String keyString) {
        driverFilterPage.tableColumns(keyString);
    }





}
