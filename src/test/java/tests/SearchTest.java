package tests;

import pages.NavigationBar;
import pages.ProductPage;
import org.testng.Assert;
import org.testng.annotations.Test;
import static utilities.TestData.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class SearchTest extends TestBase {
    private static final Logger logger = LogManager.getLogger(SearchTest.class);
    @Test
    public void SearchOnProductTest() {
        logger.info("Starting 'Search on Product' test.");
        NavigationBar navigationBar = new NavigationBar(driver);
        logger.info("Navigating to the Products page.");
        navigationBar.ClickOnProductPageNavBtn();
        ProductPage productPage = new ProductPage(driver);
        String ProductName = PRODUCT_NAME.trim().toLowerCase();
        logger.info("Searching for product. ");
        productPage.searchProduct(ProductName);
        logger.info("Asserting that the product is displayed in the search results.");
        Assert.assertTrue(productPage.isProductListContainsProductName(ProductName));
        logger.info("'Search on Product' test finished successfully.");
    }
}
