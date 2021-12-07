package com.automation.testsuite;

import com.automation.customlisteners.CustomListeners;
import com.automation.pages.HomePage;
import com.automation.pages.SignInPage;
import com.automation.testbase.TestBase;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import resources.testdata.TestData;


@Listeners(CustomListeners.class)
public class SignPageTest extends TestBase {

    HomePage homePage;
    SignInPage signInPage;

    @BeforeMethod(alwaysRun = true)
    public void init() {
        homePage = new HomePage();
        signInPage = new SignInPage();
    }

    @Test(groups = {"sanity","regression"})
    public void userShouldNavigateToSignInPageSuccessFully() {
        homePage.signInLink();
        signInPage.authenticationMessage("Authentication");
    }

    @Test(dataProvider = "userdata", dataProviderClass = TestData.class, groups = {"smoke","regression"})
    public void verifyTheErrorMessageWithInValidCredentials(String username, String password, String errorMessage) {
        homePage.signInLink();
        signInPage.wrongCredentials(username,password, errorMessage);
        signInPage.signInButton();
        signInPage.errorMessageVerify("errorMessage");
    }

    @Test(groups = {"smoke","regression"})
    public void verifyThatUserShouldLogInSuccessFullyWithValidCredentials() {
        homePage.signInLink();
        signInPage.emailAddress("bobalexa@gmail.com");
        signInPage.setPasswordField("Abc1234");
        signInPage.signInButton();
        signInPage.signOutLink();
    }

    @Test(groups = {"regression"})
    public void VerifyThatUserShouldLogOutSuccessFully() {
        homePage.signInLink();
        signInPage.emailAddress("bobalexa@gmail.com");
        signInPage.setPasswordField("Abc1234");
        signInPage.signInButton();
        signInPage.clickSignOutLink();
        signInPage.verifySignInLinkDisplayed();
    }


}
