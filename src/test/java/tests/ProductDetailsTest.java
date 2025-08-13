package tests;

import pages.NavigationBar;
import pages.ProductDetailsPage;
import pages.ProductPage;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ProductDetailsTest extends TestBase {
    private static final Logger logger = LogManager.getLogger(ProductDetailsTest.class);
    @Test
    public void VerifyProductDetailsTest(){
        logger.info("Starting 'Verify Product Details' test.");
        NavigationBar navBar = new NavigationBar(driver);
        logger.info("Navigating to the Products Page.");
        navBar.ClickOnProductPageNavBtn();
        ProductPage productPage = new ProductPage(driver);
        String firstProductPrice=productPage.getFirstElementText("h2").getText();
        String firstProductName=productPage.getFirstElementText("p").getText();
        logger.info("Clicking on the product's details.");
        productPage.clickOnFirstProductDetails();
        ProductDetailsPage productDetailsPage = new ProductDetailsPage(driver);
        logger.info("Getting product name and price from the Product Details page.");
        String ActualPrice= productDetailsPage.getProductPrice();
        String ActualName=productDetailsPage.getProductName();
        Assert.assertEquals(ActualPrice,firstProductPrice);
        Assert.assertEquals(ActualName,firstProductName);
        logger.info("'Verify Product Details' test finished successfully.");
    }
}
