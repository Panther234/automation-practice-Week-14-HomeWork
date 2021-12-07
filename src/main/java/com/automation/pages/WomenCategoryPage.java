package com.automation.pages;

import com.automation.customlisteners.CustomListeners;
import com.automation.utility.Utility;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WomenCategoryPage extends Utility {
    public WomenCategoryPage() {
        PageFactory.initElements(driver, this); }

    @FindBy(xpath = " //h2[normalize-space()='Women']")
    WebElement womenTextVerify;

    @FindBy(xpath = "//a[@class='product-name']")
    WebElement productList;

    public void verifyWomenText(String text){

        verifyThatTextIsDisplayed(womenTextVerify, text);
        CustomListeners.test.log(Status.PASS, "Verify Women Text " + text);
    }
    public void clickProductList(String text){

        clickOnElement(productList,text);
        CustomListeners.test.log(Status.PASS, "Click Product list  " + text);
    }



}
