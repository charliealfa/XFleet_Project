package com.xfleet.pages;

import com.xfleet.utilities.Driver;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    @FindBy(name = "_username")
    public WebElement usernameInpt;

    @FindBy(name = "_password")
    public WebElement passwordInpt;

    @FindBy(name = "_submit")
    public WebElement loginBtn;

    @FindBy(css = ".alert-error")
    public WebElement alertMessage;

    @FindBy(xpath = "//span[contains(text(),'Remember me')]")
    public WebElement rememberMeLink;

    @FindBy(css = "li>a.dropdown-toggle")
    public WebElement actualName;

    public LoginPage(){PageFactory.initElements(Driver.get(),this);}


    public void login(String username, String password) {
        usernameInpt.sendKeys(username);
        passwordInpt.sendKeys(password);
        loginBtn.click();

    }

    public void loginWithEnter(String username, String password) {
        usernameInpt.sendKeys(username);
        passwordInpt.sendKeys(password + Keys.ENTER);
    }

    public boolean popUpMessage(String message) {
        boolean flag = false;
        if (usernameInpt.getText().equals("")){
            if(usernameInpt.getAttribute("validationMessage").equals(message)){
                flag = true;
            }
        }
        if(passwordInpt.getText().equals("")){
                if(passwordInpt.getAttribute("validationMessage").equals(message)){
                flag = true;
            }
        }
        return flag;
    }

}
