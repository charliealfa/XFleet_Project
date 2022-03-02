package com.xfleet.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

public class VehiclesPage extends BasePage {

    @FindBy(xpath = "//button[@data-toggle='dropdown' and @class='btn dropdown-toggle ']")
    public WebElement viewPerPageDropDownButton;

    @FindBy(xpath = "//ul/li/a[@class='dropdown-item']")
    public List<WebElement> dropDownOptions;

    @FindBy(xpath = "//tbody/tr")
    public List<WebElement> vehicleRows;

    public List<String> getDropdownOptionsText() {
        List<String> dropDownOptionsText = new ArrayList<>();
        viewPerPageDropDownButton.click();
        for (WebElement option : dropDownOptions) {
            dropDownOptionsText.add(option.getText());
        }
        return dropDownOptionsText;
    }


}
