package Tests;

import Pages.CartPage;
import Pages.NavigationBar;
import Pages.ProductDetailsPage;
import Pages.ProductPage;
import org.testng.Assert;
import org.testng.annotations.Test;

import static Pages.CartPage.TotalProductPrice;

public class AddToCart extends BaseTest{
    @Test
    public void addToCart() throws InterruptedException {
        NavigationBar navBar = new NavigationBar(driver);
        navBar.ClickOnProductPageNavBtn();
        ProductPage productPage = new ProductPage(driver);
        productPage.clickOnFirstProductDetails();
        ProductDetailsPage productDetailsPage = new ProductDetailsPage(driver);
        int ProductQuantity = 2;
        String actualPriceText= productDetailsPage.getProductPrice();
        int actualPrice = Integer.parseInt(actualPriceText.replace("Rs.", "").trim());
        productDetailsPage.setProductQuantity(ProductQuantity);
        productDetailsPage.clickAddToCart();
        Thread.sleep(2000);
        Assert.assertTrue(productDetailsPage.isSuccessfulMessageDisplayed());
        Assert.assertEquals(productDetailsPage.getSuccessMessageHeader(),"Added!");
        Assert.assertEquals(productDetailsPage.getSuccessMessageParagraph(),"Your product has been added to cart.");
        productDetailsPage.clickViewCartButton();
        CartPage cartPage = new CartPage(driver);
        String totalPriceText = driver.findElement(TotalProductPrice).getText();
        int totalPrice = Integer.parseInt(totalPriceText.replace("Rs.", "").trim());
        Assert.assertEquals(totalPrice,ProductQuantity*actualPrice);
    }
}
