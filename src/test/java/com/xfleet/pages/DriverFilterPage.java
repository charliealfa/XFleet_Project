package com.xfleet.pages;

import com.xfleet.utilities.Driver;
import io.cucumber.java.bs.A;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class DriverFilterPage extends BasePage{

    //FLTAPS-1188 WebElements
    @FindBy (xpath = "//a[@title='Filters']")
    public WebElement filterIconButton;

    @FindBy (className = "add-filter-button")
    public WebElement manageFiltersDropDown;

    @FindBy (css = "input[value='Driver']")
    public WebElement driverCheckBox;


    //FLTAPS-1190 WebElements
    @FindBy (xpath = "//div[@style='display: inline-block;']")
    public WebElement driverAllDropDown;

    @FindBy (xpath = "//button[@class='btn dropdown-toggle']")
    public WebElement containsDropDown;

    @FindBy (xpath = "(//ul[@class='dropdown-menu'])[3]")
    public  WebElement listOfMethods;


    //FLTAPS-1191 WebElements

    //@FindBy (xpath = "//div[@class='value-field-frame']/*[@type='text']")

    @FindBy (xpath = "//div[@class='filter-container'] //descendant::input[@name='value']")
    public WebElement containsTextBox;

    @FindBy (xpath = "//a[@data-value='1']")
    public WebElement containsMethod;

    @FindBy (xpath = "//a[@data-value='2']")
    public WebElement doesNotContainMethod;

    @FindBy (xpath = "//a[@data-value='3']")
    public WebElement isEqualToMethod;

    @FindBy (xpath = "//a[@data-value='4']")
    public WebElement startsWithMethod;

    @FindBy (xpath = "//a[@data-value='5']")
    public WebElement endsWithMethod;

    @FindBy (xpath = "//button[text()='Update']")
    public  WebElement updateButton;

    @FindBy (className = "grid table-hover table table-bordered table-condensed")
    public WebElement table;





    public void clickMethodsByName() {

        String[] methodNames = {"does not contain", "is equal to", "starts with", "ends with"};
        containsDropDown.click();
        List<WebElement> numOfMethods = Driver.get().findElements(By.xpath("//div[@class='btn-group btn-block open'] //descendant::ul[@class='dropdown-menu']"));

        for (int i = 0; i < numOfMethods.size(); i++) {
            for (int j = 0; j < methodNames.length; j++){
                if (numOfMethods.get(i).getText().equalsIgnoreCase(methodNames[j])) {
                    numOfMethods.get(i).click();
                    System.out.println("methodNames[j] = " + methodNames[j] + "is clicked");
                }
                System.out.println("not the required method");
            }
            containsDropDown.click();
        }
    }

    public void clickMethodsByIndex() {
        for (int i = 1; i <= 5; i++){
            WebElement method = Driver.get().findElement(By.xpath("//a[@data-value='" + i + "']"));
            method.click();
            System.out.println(" method" + i  + " is clicked ");
            containsDropDown.click();
        }
    }




    public void tableRows(String keyword){
        List<WebElement> rows = Driver.get().findElements(By.xpath("//table[@class='grid table-hover table table-bordered table-condensed']/tbody/tr"));
        int countRows = rows.size();
        System.out.println("ROW COUNT : "+ countRows);
        for(WebElement r : rows) {
            Assert.assertEquals(keyword, r.getText());
            System.out.println(r.getText());
        }
    }

    public void tableColumns(String keyword){
        List<WebElement> columns = Driver.get().findElements(By.xpath("//table[@class='grid table-hover table table-bordered table-condensed']/tbody/tr[2]/td"));
        int countColumns = columns.size();
        System.out.println("countColumns = " + countColumns);
        for(WebElement c : columns){
            Assert.assertEquals(keyword, c.getText());
            System.out.println(c.getText());
        }
    }

}
