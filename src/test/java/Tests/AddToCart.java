package Tests;

import Pages.NavigationBar;
import Pages.ProductDetailsPage;
import Pages.ProductPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AddToCart extends BaseTest{
    @Test
    public void addToCart() throws InterruptedException {
        NavigationBar navBar = new NavigationBar(driver);
        navBar.ClickOnProductPageNavBtn();
        ProductPage productPage = new ProductPage(driver);
        productPage.clickOnFirstProductDetails();
        ProductDetailsPage productDetailsPage = new ProductDetailsPage(driver);
        int ProductQuantity = 2;
        productDetailsPage.setProductQuantity(ProductQuantity);
        productDetailsPage.clickAddToCart();
        Thread.sleep(2000);
        Assert.assertTrue(productDetailsPage.isSuccessfulMessageDisplayed());
        Assert.assertEquals(productDetailsPage.getSuccessMessageHeader(),"Added!");
        Assert.assertEquals(productDetailsPage.getSuccessMessageParagraph(),"Your product has been added to cart.");
    }
}
