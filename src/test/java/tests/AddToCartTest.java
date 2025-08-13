package tests;

import pages.NavigationBar;
import org.testng.annotations.Test;
import static utilities.TestData.PRODUCT_QUANTITY;

public class AddToCartTest extends tests.TestBase {
    @Test
    public void addToCart() {
        NavigationBar navBar = new NavigationBar(driver);
        navBar.ClickOnProductPageNavBtn()
                .clickOnFirstProductDetails()
                .verifyProductPrice()
                .setProductQuantity(PRODUCT_QUANTITY)
                .clickAddToCart()
                .verifyAddToCartMessage();
    }
}
