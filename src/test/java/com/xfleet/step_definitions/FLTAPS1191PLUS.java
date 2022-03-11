package com.xfleet.step_definitions;

import com.xfleet.pages.DriverFilterPage;
import io.cucumber.java.en.Given;

public class FLTAPS1191PLUS {

    DriverFilterPage driverFilterPage = new DriverFilterPage();

    @Given("user clicks methodsList drop down menu list")
    public void userClicksMethodsListDropDownMenuList() {
        driverFilterPage.clickMethodsByIndex();
    }


    @Given("user clicks checks non alphabetic characters")
    public void userClicksChecksNonAlphabeticCharacters() {
        driverFilterPage.nonAlphabeticCharacterTest();
    }
}
