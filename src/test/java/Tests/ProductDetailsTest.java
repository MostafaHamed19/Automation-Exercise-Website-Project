package tests;

import pages.NavigationBar;
import pages.ProductDetailsPage;
import pages.ProductPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ProductDetailsTest extends TestBase {
    @Test
    public void VerifyProductDetailsTest(){
        NavigationBar navBar = new NavigationBar(driver);
        navBar.ClickOnProductPageNavBtn();
        ProductPage productPage = new ProductPage(driver);
        String firstProductPrice=productPage.getFirstElementText("h2").getText();
        String firstProductName=productPage.getFirstElementText("p").getText();
        productPage.clickOnFirstProductDetails();
        ProductDetailsPage productDetailsPage = new ProductDetailsPage(driver);
        String ActualPrice= productDetailsPage.getProductPrice();
        String ActualName=productDetailsPage.getProductName();
        Assert.assertEquals(ActualPrice,firstProductPrice);
        Assert.assertEquals(ActualName,firstProductName);
    }
}
