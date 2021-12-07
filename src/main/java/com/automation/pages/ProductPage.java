package com.automation.pages;

import com.automation.customlisteners.CustomListeners;
import com.automation.utility.Utility;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductPage extends Utility {

    public ProductPage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//input[@id='quantity_wanted']")
    WebElement quantityWanted;

    @FindBy(xpath = "//select[@id='group_1']")
    WebElement sizeSelect;

    @FindBy(className = "attribute_list")
    WebElement colourSelect;

    @FindBy(xpath = "//button[@name='Submit']")
    WebElement addToCartBtn;

    @FindBy(xpath = "//h2[normalize-space()='Product successfully added to your shopping cart']")
    WebElement popUpDisplay;

    @FindBy(xpath = "//span[@title='Close window']")
    WebElement closePopUp;


    public void verifyPopUpDisplayMsg(String text){

        verifyThatTextIsDisplayed(popUpDisplay,text);
        CustomListeners.test.log(Status.PASS, "Verify PopUp Msg " + text);
    }
    public void clickOnAddToCartBtn() {

        clickOnElement(addToCartBtn);
        CustomListeners.test.log(Status.PASS, "Click Add to cart  ");
    }
    public void addQuantityWanted(String text) {

        sendKeysToElement(quantityWanted, Keys.BACK_SPACE);
        CustomListeners.test.log(Status.PASS, "Add Quantity  ");
    }

    public void selectSize(String text) {

        selectByVisibleTextFromDropDown(sizeSelect, text);
        CustomListeners.test.log(Status.PASS, "Select Size ");
    }

    public void selectColor(String colour) {

        clickOnElement(colourSelect, colour);
        CustomListeners.test.log(Status.PASS, "Select Colour ");
    }
    public void closePopUpButton(){

        clickOnElement(closePopUp);
        CustomListeners.test.log(Status.PASS, "Close PopUP");
    }


}
