package com.xfleet.step_definitions;

import com.xfleet.pages.GridPage;
import com.xfleet.pages.LoginPage;
import com.xfleet.utilities.BrowserUtils;
import com.xfleet.utilities.ConfigurationReader;
import com.xfleet.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.util.List;


public class GridPageStepDefs {

    @Given("the {string} is on home page")
    public void theIsOnHomePage(String userType) {
        Driver.get().get(ConfigurationReader.get("url"));
        new LoginPage().loginAsUser(userType);
    }

    @When("the user navigates to {string} {string}")
    public void theUserNavigatesTo(String tab, String module) {
        BrowserUtils.waitForPageToLoad(15);
        new GridPage().navigateToModule(tab, module);
        new GridPage().waitUntilLoaderScreenDisappear();
    }

    @When("the user click the Grid button")
    public void theUserClickTheGridButton() {
        new GridPage().gridButton.click();
    }

    @Then("verify that the user should see Grid Settings title")
    public void verifyThatTheUserShouldSeeGridSettingsTitle() {
        Assert.assertEquals("grid title not match","Grid Settings",new GridPage().gridSettingsTitle.getText());
    }

    @Then("verify that the user should see the following Grid Settings options")
    public void verifyThatTheUserShouldSeeTheFollowingGridSettingsOptions(List<String> gridOptions) {
        List<String> gridSettingsList = BrowserUtils.getElementsText(new GridPage().gridSettingsLabels);
        Assert.assertEquals(gridOptions,gridSettingsList);
    }

    @And("the user type {string} in Quick Search box")
    public void theUserTypeInQuickSearchBox(String searchOption) {
        new GridPage().quickSearchBox.sendKeys(searchOption);
    }

    @Then("verify that the search result gives {string} option")
    public void verifyThatTheSearchResultGivesTheRightOption(String searchOption) {
        Assert.assertEquals(1,new GridPage().searchBoxResults.size());
        Assert.assertTrue(searchOption.equalsIgnoreCase(new GridPage().searchBoxResults.get(0).getText()));
    }

    @And("the user click {string} checkbox")
    public void theUserClickCheckbox(String columnName) {
        Assert.assertTrue(new GridPage().getCheckBoxElement(columnName).isSelected());
        new GridPage().getGridNameLabel(columnName).click();
    }

    @Then("verify that the status of {string} checkbox changed")
    public void verifyThatTheStatusOfCheckboxChanged(String columnName) {
        Assert.assertFalse(new GridPage().getCheckBoxElement(columnName).isSelected());
    }

    @And("the user drag {string} box to {string} box")
    public void theUserDragBoxToBox(String drag, String drop) {
        BrowserUtils.waitFor(1);//Added By @CharlieAlfa
        new GridPage().dragAndDropGridElement(drag,drop);
    }


    @Then("verify that {string} columns order changed")
    public void verifyThatColumnsOrderChanged(String dragOption) {
        int i=GridPage.initialIndexOfDrop;
        BrowserUtils.waitFor(2);
        Assert.assertEquals(dragOption,new GridPage().gridSettingsLabels.get(i).getText());
    }

    @And("the user click {string} and {string}")
    public void theUserClickAnd(String gridOption1, String gridOption2) {
        new GridPage().getCheckBoxElement(gridOption1).click();
        new GridPage().getCheckBoxElement(gridOption2).click();
    }

    @Then("verify that the labels order in Grid Settings is the same as the columns order in table")
    public void verifyThatTheLabelsOrderInGridSettingsIsTheSameAsTheColumnsOrderInTable() {
        List<String> headersOfTable = new GridPage().getHeadersOfTable();
        List<String> selectedGridList = new GridPage().getSelectedGridCheckbox();
        Assert.assertEquals(selectedGridList,headersOfTable);
    }
}