package com.automation.testsuite;

import com.automation.customlisteners.CustomListeners;
import com.automation.pages.HomePage;
import com.automation.pages.ProductPage;
import com.automation.pages.WomenCategoryPage;
import com.automation.testbase.TestBase;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import resources.testdata.TestData;


@Listeners(CustomListeners.class)
public class WomenCategoryPageTest extends TestBase {

    HomePage homePage;
    WomenCategoryPage womenCategoryPage;
    ProductPage productPage;

    @BeforeMethod(alwaysRun = true)
    public void inIt() {
        homePage = new HomePage();
        womenCategoryPage = new WomenCategoryPage();
        productPage = new ProductPage();

    }
    @Test(groups = {"sanity","regression"})
    public void verifyUserShouldNavigateToWomenCategoryPageSuccessfully(){
        homePage.selectMenu("Women");
        womenCategoryPage.verifyWomenText("Women");
    }


    @Test(dataProvider = "productdata", dataProviderClass = TestData.class, groups = {"regression"})
    public void verifyUserShouldAddProductToTheCartSuccessfully(String product, String qty, String size, String colour){
        homePage.selectMenu("Women");
        womenCategoryPage.clickProductList(product);
        productPage.addQuantityWanted(qty);
        productPage.selectSize(size);
        productPage.selectColor(colour);
        productPage.clickOnAddToCartBtn();
        productPage.verifyPopUpDisplayMsg("Product successfully added to your shopping cart");
        productPage.closePopUpButton();
    }
}
