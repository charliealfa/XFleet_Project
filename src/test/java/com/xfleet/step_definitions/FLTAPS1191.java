package com.xfleet.step_definitions;

import com.xfleet.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;

public class FLTAPS1191 {

    @Given("user inputs {string} keyword into text box")
    public void user_inputs_keyword_into_text_box(String keyword) {
        Driver.get().findElement(By.xpath("//div[@class='value-field-frame']/*[@type='text']")).sendKeys(keyword);
    }

    @When("user clicks {string} button")
    public void user_clicks_button(String button) {
        Driver.get().findElement(By.xpath("//button[text()='Update']")).click();
    }

    @Then("results with {string} are displayed only")
    public void results_with_are_displayed_only(String keyword) {

    }

}
