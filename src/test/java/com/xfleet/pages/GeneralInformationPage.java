package com.xfleet.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class GeneralInformationPage extends BasePage{

    @FindBy(xpath = "//h5/span")
    public WebElement generalInformationHeader;

}
