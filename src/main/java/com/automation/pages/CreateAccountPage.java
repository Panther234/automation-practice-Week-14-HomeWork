package com.automation.pages;

import com.automation.customlisteners.CustomListeners;
import com.automation.utility.Utility;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateAccountPage extends Utility {

    public CreateAccountPage() {
        PageFactory.initElements(driver, this);
    }


    @FindBy(id = "customer_firstname")
    WebElement firstName;

    @FindBy(id = "customer_lastname")
    WebElement lastName;

    @FindBy(id = "passwd")
    WebElement password;

    @FindBy(id = "firstname")
    WebElement firstNameField;

    @FindBy(id = "lastname")
    WebElement lastNameField;

    @FindBy(id = "address1")
    WebElement address;

    @FindBy(id = "city")
    WebElement city;

    @FindBy(id = "id_state")
    WebElement state;

    @FindBy(id = "id_state")
    WebElement zipcode;

    @FindBy(id = "phone_mobile")
    WebElement phoneNumber;

    @FindBy(id = "alias")
    WebElement reference;

    @FindBy(xpath = "//span[normalize-space()='Register']")
    WebElement registerbtn;

    public void clickOnRegisterBtn(){

        clickOnElement(registerbtn);
        CustomListeners.test.log(Status.PASS, "Click register");
    }

    public void enterAddress(String text){

        sendTextToElement(address,text);
        CustomListeners.test.log(Status.PASS, "Enter Address " + text);
    }

    public void enterCity(String text){

        sendTextToElement(city,text);
        CustomListeners.test.log(Status.PASS, "Enter City" + text);
    }

    public void enterZipCode(String text){

        sendTextToElement(zipcode,text);
        CustomListeners.test.log(Status.PASS, "Enter Zipcode" + text);
    }

    public void enterPhoneNumber(String text){

        sendTextToElement(phoneNumber,text);
        CustomListeners.test.log(Status.PASS, "Enter PhoneNumber" + text);
    }

    public void enterReference(String text){
        sendTextToElement(reference,text);
        CustomListeners.test.log(Status.PASS, "Select Reference" + text);
    }

    public void selectState(String text){
        sendTextToElement(state,text);
        CustomListeners.test.log(Status.PASS, "Select state " + text);
    }

    public void enterFirstName(String text){
        sendTextToElement(firstName,text);
        CustomListeners.test.log(Status.PASS, "Enter Firstname" + text);
    }
    public void enterLastName(String text){
        sendTextToElement(lastName,text);
        CustomListeners.test.log(Status.PASS, "Enter Lastname " + text);
    }
    public void enterFirstNameField(String text){
        sendTextToElement(firstNameField,text);
        CustomListeners.test.log(Status.PASS, "Send text to Firstname" + text);
    }
    public void enterLastNameField(String text){
        sendTextToElement(lastNameField,text);
        CustomListeners.test.log(Status.PASS, "Send text to Lastname" + text);
    }
    public void enterPassword(String text){
        sendTextToElement(password,text);
        CustomListeners.test.log(Status.PASS, "Send text to Password" + text);
    }


}
