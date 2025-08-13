package tests;

import pages.NavigationBar;
import org.testng.annotations.Test;
import static utilities.TestData.PRODUCT_QUANTITY;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class AddToCartTest extends tests.TestBase {
    private static final Logger logger = LogManager.getLogger(AddToCartTest.class);
    @Test
    public void addToCart() {
        logger.info("Starting 'Add to Cart' test.");
        NavigationBar navBar = new NavigationBar(driver);
        logger.info("Clicking on 'Products' page navigation button.");
        navBar.ClickOnProductPageNavBtn()
                .clickOnFirstProductDetails()
                .verifyProductPrice()
                .setProductQuantity(PRODUCT_QUANTITY)
                .clickAddToCart()
                .verifyAddToCartMessage();
        logger.info("'Add to Cart' test finished successfully.");
    }
}
