package com.xfleet.pages;

import com.xfleet.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class VehiclesPage extends BasePage {
    // ErcanEAK project code's line STARTS here
    @FindBy(xpath = "(//tbody//tr/td[2])[5]")
    public WebElement anyVehicles;

    @FindBy(xpath = "//a[@title='Add an event to this record']")
    public WebElement addEventButton;

    public VehiclesPage() {

        PageFactory.initElements(Driver.get(), this);
    }

    // ErcanEAK project code's line ENDS here





    // esalkan project code's line STARTS here

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


    // esalkan project code's line ENDS here

}
