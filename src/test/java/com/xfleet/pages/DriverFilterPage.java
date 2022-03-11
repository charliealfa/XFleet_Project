package com.xfleet.pages;

import com.xfleet.utilities.BrowserUtils;
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
    @FindBy (xpath = "//div[@class='value-field-frame']/input[@name='value']")
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




    public void table(){

        List<WebElement> headers = Driver.get().findElements(By.xpath("//table[@class='grid table-hover table table-bordered table-condensed']//th"));
//        System.out.println("headers = " + headers.size());

        List<WebElement> numOfRows = Driver.get().findElements(By.xpath("//table[@class='grid table-hover table table-bordered table-condensed']/tbody/tr"));
        System.out.println("Total results = " + numOfRows.size());

        System.out.println("column = " + headers.get(2).getText().toUpperCase());//count from zero

        for (int i = 1; i <= numOfRows.size(); i++){
            WebElement columnCell = Driver.get().findElement(By.xpath("//table[@class='grid table-hover table table-bordered table-condensed']/tbody/tr[" + i + "]/td[3]"));
            System.out.println(headers.get(2).getText().toUpperCase() + " Cell" + i + " = " + columnCell.getText());
        }

    }



    public void clickMethodsByIndex() {
        String keyword = "\"Miss\"";
        System.out.println("=====================================================================================");
        System.out.println("String Keyword " + keyword + " is used with methods");

        for (int i = 1; i <= 5; i++){
            WebElement method = Driver.get().findElement(By.xpath("//a[@data-value='" + i + "']"));
            method.click();
            if (i == 1){
                System.out.println("CONTAINS METHOD" + " is clicked ");
            }else if (i == 2){
                System.out.println("DOES NOT CONTAIN METHOD" + " is clicked ");
            }else if (i == 3){
                System.out.println("IS EQUAL METHOD"  + " is clicked ");
            }else if (i == 4){
                System.out.println("STARTS WITH METHOD" + " is clicked ");
            }else {
                System.out.println("ENDS WITH METHOD"  + " is clicked ");
            }
            containsTextBox.sendKeys(keyword);
            updateButton.click();
            BrowserUtils.waitFor(6);
            table();
            System.out.println("=====================================================================================");
            driverAllDropDown.click();
            containsDropDown.click();
        }

    }


    public void nonAlphabeticCharacterTest(){
        String nonAlphabeticCharacters = "!@#$%^&*()_+{}|:\"<>?/\\";
        System.out.println("=====================================================================================");
        System.out.println("Non alphabetic character string " + nonAlphabeticCharacters + " is used with methods");

        for (int i = 1; i <= 5; i++){
            WebElement method = Driver.get().findElement(By.xpath("//a[@data-value='" + i + "']"));
            method.click();
            if (i == 1){
                System.out.println("CONTAINS METHOD" + " is clicked ");
            }else if (i == 2){
                System.out.println("DOES NOT CONTAIN METHOD" + " is clicked ");
            }else if (i == 3){
                System.out.println("IS EQUAL METHOD"  + " is clicked ");
            }else if (i == 4){
                System.out.println("STARTS WITH METHOD" + " is clicked ");
            }else {
                System.out.println("ENDS WITH METHOD"  + " is clicked ");
            }
            containsTextBox.sendKeys(nonAlphabeticCharacters);
            updateButton.click();
            BrowserUtils.waitFor(6);
            Assert.assertFalse("Update button should be disabled", updateButton.isEnabled());
            System.out.println("=====================================================================================");
            driverAllDropDown.click();
            containsDropDown.click();
        }
    }



}
