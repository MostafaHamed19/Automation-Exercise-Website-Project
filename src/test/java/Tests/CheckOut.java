package Tests;

import Pages.*;
import org.testng.Assert;
import org.testng.annotations.Test;

import static Helpers.TestData.EXISTING_EMAIL;
import static Helpers.TestData.VALID_PASSWORD;

public class CheckOut extends BaseTest{
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
        cartPage.FillCardInformation("John","1111222233334444","1234","12","2030");
        cartPage.ClickOnPaymentButton();
        String status = cartPage.getOrderStatus();
        String successMsg = cartPage.getSuccessMessage();
        Assert.assertEquals(status, "ORDER PLACED!");
        Assert.assertEquals(successMsg, "Congratulations! Your order has been confirmed!");
    }
}
