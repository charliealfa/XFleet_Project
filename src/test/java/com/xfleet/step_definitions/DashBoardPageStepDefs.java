package com.xfleet.step_definitions;

import com.xfleet.pages.DashBoardPage;
import com.xfleet.utilities.BrowserUtils;
import com.xfleet.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;

import java.util.ArrayList;

public class DashBoardPageStepDefs {

    DashBoardPage dashBoardPage = new DashBoardPage();

    @When("users click the {string} button")
    public void usersClickTheButton(String logOutBtn) {
        BrowserUtils.waitForVisibility(dashBoardPage.userMenu,15);
        dashBoardPage.userMenu.click();
        dashBoardPage.logOutBtn.click();
    }

    @And("click step back button")
    public void clickStepBackButton() {
        Driver.get().navigate().back();
    }

    @When("close the tab")
    public void closeTheTab() {
        JavascriptExecutor jse = (JavascriptExecutor)Driver.get();
        jse.executeScript("window.open()");
        ArrayList<String> tabs = new ArrayList<String>(Driver.get().getWindowHandles());
        Driver.get().close();
        Driver.get().switchTo().window(tabs.get(1));
    }

    @Then("go to url of dashboard page")
    public void goToUrlOfDashboardPage() {

        Driver.get().get("http://qa.xfleetsolutions.com/");
    }

    @And("verify not login")
    public void verifyNotLogin() {
        Assert.assertEquals(Driver.get().getTitle(),"Login");
    }

    @And("navigate to {string} {string} page")
    public void navigateToPage(String tab, String module) {
        dashBoardPage.waitUntilLoaderScreenDisappear();
        dashBoardPage.navigateTo(tab,module);
        }
}
