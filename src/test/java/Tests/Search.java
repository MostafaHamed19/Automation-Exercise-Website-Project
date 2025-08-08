package Tests;

import Pages.NavigationBar;
import Pages.ProductPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Search extends BaseTest{
    @Test
    public void SearchOnProductTest() throws InterruptedException {
        NavigationBar navigationBar = new NavigationBar(driver);
        navigationBar.ClickOnProductPageNavBtn();
        ProductPage productPage = new ProductPage(driver);
        String ProductName = "Cotton".trim().toLowerCase();
        productPage.searchProduct(ProductName);
        Assert.assertTrue(productPage.isProductListContainsProductName(ProductName));
    }
}
