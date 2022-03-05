package com.xfleet.pages;

import com.xfleet.utilities.BrowserUtils;
import com.xfleet.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class VehiclesPage extends BasePage {
    // ErcanEAK project code's line STARTS here
    @FindBy(xpath = "(//tbody//tr/td[2])[5]")
    public WebElement anyVehicles;

    @FindBy(xpath = "//a[@title='Add an event to this record']")
    public WebElement addEventButton;

    // ErcanEAK project code's line ENDS here


    // Eren project code's line STARTS here

    @FindBy(xpath = "//a[@title='View']")
    public WebElement eyeIcon;

    @FindBy(xpath = "(//a[@data-toggle='dropdown'])[11]")
    public WebElement anyThreeDot;

    @FindBy(xpath = "//tr[6]/td[contains(@class,'grid-cell')]")
    public List<WebElement> anyRowInformationList;


    // Eren project code's line ENDS here


    // esalkan project code's line STARTS here

    @FindBy(xpath = "//div[@class='page-size pull-right form-horizontal']/div/div[starts-with(@class,'btn-group')]")
    public WebElement viewPerPageDropDownButton;

    @FindBy(xpath = "//*/ul/li/a[@class='dropdown-item']")
    public List<WebElement> dropDownOptions;

    @FindBy(xpath = "//tbody/tr")
    public List<WebElement> vehicleRows;

    @FindBy(xpath = "//table/thead/tr/th/a/span[contains(text(),'Model Year')]")
    public WebElement modelYearTab;

    @FindBy(xpath = "//div[@class='pull-right grid-toolbar-tools']//a[@title='Reset']")
    public WebElement resetButton;

    public List<String> getDropdownOptionsText() {
        List<String> dropDownOptionsText = new ArrayList<>();
        viewPerPageDropDownButton.click();
        for (WebElement option : dropDownOptions) {
            dropDownOptionsText.add(option.getText());
        }
        return dropDownOptionsText;
    }

    public boolean tableSortResult() {
        int counter = vehicleRows.size();
        List<String> beforeSortRowCellData = new ArrayList<>();
        for (int i = 1; i <= counter; i++) {
            beforeSortRowCellData.add(Driver.get().findElement(By.xpath("//table/tbody/tr[" + i + "]/td[7]")).getText());
        }
        modelYearTab.click();
        BrowserUtils.waitFor(2);
        int sortCounter = vehicleRows.size();
        List<String> afterSortRowCellData = new ArrayList<>();
        for (int i = 1; i <= sortCounter; i++) {
            afterSortRowCellData.add(Driver.get().findElement(By.xpath("//table/tbody/tr[" + i + "]/td[7]")).getText());
        }
        return Objects.equals(beforeSortRowCellData.get(24), afterSortRowCellData.get(24));
    }

    // esalkan project code's line ENDS here

}
