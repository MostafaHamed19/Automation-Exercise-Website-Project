package tests;

import pages.CartPage;
import pages.NavigationBar;
import pages.ProductDetailsPage;
import pages.ProductPage;
import org.testng.Assert;
import org.testng.annotations.Test;

import static pages.CartPage.TotalProductPrice;
import static utilities.TestData.PRODUCT_QUANTITY;

public class AddToCartTest extends TestBase {
    @Test
    public void addToCart() throws InterruptedException {
        NavigationBar navBar = new NavigationBar(driver);
        navBar.ClickOnProductPageNavBtn();
        ProductPage productPage = new ProductPage(driver);
        productPage.clickOnFirstProductDetails();
        ProductDetailsPage productDetailsPage = new ProductDetailsPage(driver);
        String actualPriceText= productDetailsPage.getProductPrice();
        int actualPrice = Integer.parseInt(actualPriceText.replace("Rs.", "").trim());
        productDetailsPage.setProductQuantity(PRODUCT_QUANTITY);
        productDetailsPage.clickAddToCart();
        Thread.sleep(2000);
        Assert.assertTrue(productDetailsPage.isSuccessfulMessageDisplayed());
        Assert.assertEquals(productDetailsPage.getSuccessMessageHeader(),"Added!");
        Assert.assertEquals(productDetailsPage.getSuccessMessageParagraph(),"Your product has been added to cart.");
        productDetailsPage.clickViewCartButton();
        CartPage cartPage = new CartPage(driver);
        String totalPriceText = driver.findElement(TotalProductPrice).getText();
        int totalPrice = Integer.parseInt(totalPriceText.replace("Rs.", "").trim());
        Assert.assertEquals(totalPrice,PRODUCT_QUANTITY*actualPrice);
    }
}
