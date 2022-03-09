package com.xfleet.pages;

import com.xfleet.utilities.BrowserUtils;
import com.xfleet.utilities.Driver;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

public class VehiclesPage extends BasePage {

    // ErcanEAK project code's line STARTS here
    @FindBy(xpath = "(//tbody//tr/td[2])[5]")
    public WebElement anyVehicles;

    @FindBy(xpath = "//a[@title='Add an event to this record']")
    public WebElement addEventButton;    //#ui-id-1 id of pop up

    @FindBy(id = "ui-id-1 id of pop up")
    public WebElement AddEventpopUp;

    @FindBy(css = ".control-label.wrap")
    public List<WebElement> addEventPopUpInptLabels;

    @FindBy(xpath = "//button[text()='Cancel']")
    public WebElement getAddEventpopUpCancel;

    @FindBy(xpath = "//span[text()='This value should not be blank.']")
    public WebElement ErrorMsgOfAddEvent;

    @FindBy(css = "button[type='submit']")
    public WebElement addEventButtonSaveButton;

    public void checkMandatoryItems(List<String> expectedTitles) {
        try {
            for (WebElement e : addEventPopUpInptLabels) {
                if (expectedTitles.contains(e.getText())) {
                    Assert.assertEquals("required", e.getAttribute("class"));
                }
            }
        } catch (AssertionError assertionError) {
            assertionError.printStackTrace();
        } finally {
            getAddEventpopUpCancel.click();
        }
    }
    // ErcanEAK project code's line ENDS here


    // Eren project code's line STARTS here

    @FindBy(xpath = "//a[@title='View']")
    public WebElement eyeIcon;

    @FindBy(xpath = "(//a[@data-toggle='dropdown'])[11]")
    public WebElement anyThreeDot;

    @FindBy(xpath = "//tr[6]/td[contains(@class,'grid-cell')]")
    public List<WebElement> anyRowInformationList;


    // Eren project code's line ENDS heredf


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
        return tableSortResult();
    }

    // esalkan project code's line ENDS here

    // Erdem's codes starting

    @FindBy(xpath = "//i[@class='fa-chevron-right hide-text']")
    public WebElement nextPageButton;

    @FindBy(xpath = "//label[@class='dib'][2]")
    public WebElement textOfTotalPage;

    @FindBy(xpath = "//input[@type='number']")
    public WebElement totalPage;


    public Integer getTotalPageNumber() {

        String text = textOfTotalPage.getText();
        String totalPageNumber = text.split(" ")[1];
        System.out.println(totalPageNumber);

        int ActualTotalPageNumber = Integer.parseInt(totalPageNumber);

        return ActualTotalPageNumber;
    }

    public Integer getNumberOfCurrentPage() {

        for (int i = 1; i < getTotalPageNumber(); i++) {
            nextPageButton.click();
            BrowserUtils.waitFor(3);
        }
        String pageNumberText = totalPage.getAttribute("value");
        System.out.println("pageNumberText = " + pageNumberText);
        int pageNumber = Integer.parseInt(pageNumberText);
        return pageNumber;

    }

// Erdem's codes finished


//Huseyin's code STARTS here

    @FindBy(xpath = "/html/body/div[5]/div[2]/div/div/div/form/fieldset/div[1]/div[3]/div[2]/span/span[1]")
    public WebElement popUpColorSelect;

    @FindBy(xpath ="//input[starts-with(@id,'oro_calendar_event_form_allDay-uid')]")
    public WebElement AllDayEventCheckbox;

    @FindBy(xpath ="//input[starts-with(@id,'time_selector_oro_calendar_event_form_start-uid')]")
    public WebElement timeBoxes;

    @FindBy(xpath = "//input[starts-with(@id,'recurrence-repeat')]")
    public WebElement repeatCheckbox;

    @FindBy(css = ".recurrence-repeats__select")
    public WebElement repeatDropdown;

    @FindBy(xpath = "//div[@class='controls recurrence-subview-control recurrence-subview-control__items']//input[@type='radio']")
    public List<WebElement> endsOptions;

    public void verifyEndingOptions() {
        for (WebElement e:endsOptions) {
            Assert.assertTrue(e.isEnabled());
        }
    }
    @FindBy(xpath = "//input[starts-with(@id,'oro_calendar_event_form_title-uid')]")
    public WebElement eventTitle;
    public String anyTitleName = "bmw";

    @FindBy(xpath = "//div[@class='accordion-heading clearfix']//strong")
    public List<WebElement> saveOptions;

//  Huseyin code ENDS here

}

