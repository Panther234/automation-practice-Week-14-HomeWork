package com.automation.pages;

import com.automation.customlisteners.CustomListeners;
import com.automation.utility.Utility;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignInPage extends Utility {
    public SignInPage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//h1[normalize-space()='Authentication']")
    WebElement verifyAuthenticationMessage;

    @FindBy(xpath = "//input[@id='email']")
    WebElement emailField;

    @FindBy(xpath = "//input[@id='passwd']")
    WebElement passwordField;

    @FindBy(xpath = "//span[normalize-space()='Sign in']")
    WebElement clickSignInButton;

    @FindBy(xpath = "//div[@class='alert alert-danger']//ol")
    WebElement errorMessageDisplayed;

    @FindBy(xpath = "//a[@title='Log me out']")
    WebElement signOutLink;

    @FindBy(xpath = "//input[@id='email_create']")
    WebElement emailCreate;

    @FindBy(xpath = "//span[normalize-space()='Create an account']")
    WebElement createAccountButton;


    public void authenticationMessage(String text) {

        verifyThatTextIsDisplayed(verifyAuthenticationMessage, text);
        CustomListeners.test.log(Status.PASS, "Verify Text displayed  " + text);
    }

    public void signInButton() {

        clickOnElement(clickSignInButton);
        CustomListeners.test.log(Status.PASS, "Click SignIn " );
    }

    public void wrongCredentials(String username, String password, String errorMessage) {

        sendTextToElement(emailField, username);
        sendTextToElement(passwordField, password);
        CustomListeners.test.log(Status.PASS, "Wrong credential"+username+password  );
    }
    public void errorMessageVerify(String errorMessage) {

        verifyThatTextIsDisplayed(errorMessageDisplayed, errorMessage);
        CustomListeners.test.log(Status.PASS, "Verify Error  " + errorMessage);
    }

    public void emailAddress(String text) {
        sendTextToElement(emailField, text);
        CustomListeners.test.log(Status.PASS, "Send Email " + text);
    }

    public void setPasswordField(String text) {

        sendTextToElement(passwordField, text);
        CustomListeners.test.log(Status.PASS, "Send Password " + text);
    }

    public void signOutLink() {

        verifyThatElementIsDisplayed(signOutLink);
        CustomListeners.test.log(Status.PASS, "Verify SignOut link " );
    }

    public void clickSignOutLink() {

        clickOnElement(signOutLink);
        CustomListeners.test.log(Status.PASS, "Click SignOut link" );
    }

    public void verifySignInLinkDisplayed() {

        verifyThatElementIsDisplayed(clickSignInButton);
        CustomListeners.test.log(Status.PASS, "verify SignIn link" );
    }

    public void enterEmail(String text) {

        sendTextToElement(emailCreate, text);
        CustomListeners.test.log(Status.PASS, "Enter Email " + text);
    }
    public void clickCreateAccountButton() {

        clickOnElement(createAccountButton);
        CustomListeners.test.log(Status.PASS, "Click create account " );
    }
}
