package tests;

import pages.*;
import org.testng.Assert;
import org.testng.annotations.Test;

import static utilities.TestData.*;

public class CheckOutTest extends TestBase {
    @Test
    public void checkOut() {
        NavigationBar navBar = new NavigationBar(driver);
        navBar.ClickOnLoginAndSignUpPageNavBtn();
        LoginAndSignupPage loginAndSignupPage = new LoginAndSignupPage(driver);
        loginAndSignupPage.FillLoginEmailAndPassword(EXISTING_EMAIL,VALID_PASSWORD);
        loginAndSignupPage.ClickLoginBtn();
        navBar.ClickOnProductPageNavBtn();
        ProductPage productPage = new ProductPage(driver);
        productPage.clickOnAddToCartFirstProduct();
        productPage.clickViewCartButton();
        CartPage cartPage = new CartPage(driver);
        cartPage.clickProceedToCheckout();
        cartPage.clickPlaceOrder();
        cartPage.FillCardInformation(VALID_NAME,NUMBER,CVV,EXPIRY_MONTH,EXPIRY_YEAR);
        cartPage.ClickOnPaymentButton();
        String status = cartPage.getOrderStatus();
        String successMsg = cartPage.getSuccessMessage();
        Assert.assertEquals(status, "ORDER PLACED!");
        Assert.assertEquals(successMsg, "Congratulations! Your order has been confirmed!");
    }
}
