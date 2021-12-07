package com.automation.testsuite;

import com.automation.customlisteners.CustomListeners;
import com.automation.pages.CreateAccountPage;
import com.automation.pages.HomePage;
import com.automation.pages.SignInPage;
import com.automation.testbase.TestBase;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;


@Listeners(CustomListeners.class)
public class CreateAccountPageTest extends TestBase {

    HomePage homePage;
    SignInPage signInPage;
    CreateAccountPage createAccountPage;

    @BeforeMethod(alwaysRun = true)
    public void inIt() {
        homePage = new HomePage();
        signInPage = new SignInPage();
        createAccountPage = new CreateAccountPage();
    }

    @Test(groups = {"sanity","smoke","regression"})
    public void verifyThatUserShouldCreateAccountSuccessfully() {
        homePage.signInLink();
        signInPage.enterEmail(getRandomEmail());
        signInPage.clickCreateAccountButton();
        createAccountPage.enterFirstName("Bob");
        createAccountPage.enterLastName("Alexa");
        createAccountPage.enterPassword("Abc1234");
        createAccountPage.enterFirstNameField("Bob");
        createAccountPage.enterLastNameField("Alexa");
        createAccountPage.enterAddress("1, Bond Street");
        createAccountPage.enterCity("london");
        createAccountPage.selectState("Alaska");
        createAccountPage.enterZipCode("12345");
        createAccountPage.enterPhoneNumber("0123456789");
        createAccountPage.enterReference("Home");
        createAccountPage.clickOnRegisterBtn();
    }

}
