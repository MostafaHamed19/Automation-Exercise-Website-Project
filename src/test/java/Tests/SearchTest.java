package tests;

import pages.NavigationBar;
import pages.ProductPage;
import org.testng.Assert;
import org.testng.annotations.Test;
import static utilities.TestData.*;


public class SearchTest extends TestBase {
    @Test
    public void SearchOnProductTest() {
        NavigationBar navigationBar = new NavigationBar(driver);
        navigationBar.ClickOnProductPageNavBtn();
        ProductPage productPage = new ProductPage(driver);
        String ProductName = PRODUCT_NAME.trim().toLowerCase();
        productPage.searchProduct(ProductName);
        Assert.assertTrue(productPage.isProductListContainsProductName(ProductName));
    }
}
