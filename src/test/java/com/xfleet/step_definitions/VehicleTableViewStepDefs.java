package com.xfleet.step_definitions;

import com.xfleet.pages.GridPage;
import com.xfleet.utilities.BrowserUtils;
import io.cucumber.java.en.Then;
import org.junit.Assert;

import java.util.List;

public class VehicleTableViewStepDefs {

    GridPage gridPage = new GridPage();
    @Then("verify that user should see Table Headers and information")
    public void verify_that_user_should_see_Table_Headers_and_information(List<String> expectedHeaders) {


        List<String> actualHeaders = BrowserUtils.getElementsText(gridPage.headersOfVahicleTable);
        Assert.assertTrue(actualHeaders.containsAll(expectedHeaders));

    }
}
