package com.xfleet.step_definitions;

import com.xfleet.pages.GridPage;
import com.xfleet.pages.VehiclesPage;
import com.xfleet.utilities.BrowserUtils;
import io.cucumber.java.en.Then;
import org.junit.Assert;

import java.util.List;

public class VehicleTableViewStepDefs {

    GridPage gridPage = new GridPage();
    VehiclesPage vehiclesPage = new VehiclesPage();

    @Then("verify that user should see Table Headers and information")
    public void verify_that_user_should_see_Table_Headers_and_information(List<String> expectedHeaders) {


        List<String> actualHeaders = BrowserUtils.getElementsText(gridPage.headersOfVahicleTable);
        Assert.assertTrue(actualHeaders.containsAll(expectedHeaders));

    }

    @Then("verify that user should see the total page number")
    public void verifyThatUserShouldSeeTheTotalPageNumber() {

        int actualPageNumber = vehiclesPage.getTotalPageNumber();
        int expectedPageNumber = vehiclesPage.getNumberOfCurrentPage();

        Assert.assertEquals(expectedPageNumber,actualPageNumber);

    }

    @Then("verify that user should go next page clicking > button")
    public void verifyThatUserShouldGoNextPageClickingButton() {

        int currentPageNumber = vehiclesPage.getPageNumber();
        vehiclesPage.nextPageButton.click();
        BrowserUtils.waitFor(3);
        int nextPageNumber = vehiclesPage.getPageNumber();


        int expectedPageNumber = currentPageNumber+1;
        int actualPageNumber = nextPageNumber;

        Assert.assertEquals(expectedPageNumber,actualPageNumber);

    }

    @Then("verify that user should go previous page clicking < button")
    public void verifyThatUserShouldGoPreviousPageClickingButton() {


        int currentPageNumber = vehiclesPage.getPageNumber();

        vehiclesPage.previousPageButton.click();
        BrowserUtils.waitFor(3);
        int previousPageNumber = vehiclesPage.getPageNumber();

        System.out.println("currentPageNumber = " + currentPageNumber);
        System.out.println("previousPageNumber = " + previousPageNumber);
        int expectedPageNumber = currentPageNumber-1;
        int actualPageNumber = previousPageNumber;

        Assert.assertEquals(expectedPageNumber,actualPageNumber);


    }
}
