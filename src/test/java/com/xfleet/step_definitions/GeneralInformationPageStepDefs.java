package com.xfleet.step_definitions;

import com.xfleet.pages.GeneralInformationPage;
import io.cucumber.java.en.Then;
import org.junit.Assert;

public class GeneralInformationPageStepDefs {

    GeneralInformationPage generalInformationPage = new GeneralInformationPage();

    @Then("user should be on General Information page")
    public void user_should_be_on_General_Information_page() {
        Assert.assertEquals("Header is not as expected","General Information",generalInformationPage.generalInformationHeader.getText());
    }
}
