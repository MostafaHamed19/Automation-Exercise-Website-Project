package tests;

import pages.*;
import org.testng.annotations.Test;
import static utilities.TestData.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class CheckOutTest extends TestBase {
    private static final Logger logger = LogManager.getLogger(CheckOutTest.class);
    @Test
    public void checkOut() {
        logger.info("Starting 'Checkout' test.");
        NavigationBar navBar = new NavigationBar(driver);
        logger.info("Navigating to login page.");
        navBar.ClickOnLoginAndSignUpPageNavBtn();
        LoginAndSignupPage loginAndSignupPage = new LoginAndSignupPage(driver);
        logger.info("Logging in with existing user credentials.");
        loginAndSignupPage.login(EXISTING_EMAIL,VALID_PASSWORD);
        logger.info("Navigating to products page.");
        navBar.ClickOnProductPageNavBtn();
        ProductPage productPage = new ProductPage(driver);
        logger.info("Adding the product to cart.");
        productPage.clickOnAddToCartFirstProduct();
        logger.info("Viewing the cart to proceed to checkout.");
        productPage.clickViewCartButton();
        CartPage cartPage = new CartPage(driver);
        logger.info("Proceeding to checkout from the cart.");
        cartPage.clickProceedToCheckout();
        logger.info("Placing the order.");
        cartPage.clickPlaceOrder();
        logger.info("Filling in payment card information.");
        cartPage.FillCardInformation(VALID_NAME,NUMBER,CVV,EXPIRY_MONTH,EXPIRY_YEAR);
        logger.info("Clicking the payment button.");
        cartPage.ClickOnPaymentButton();
        logger.info("Verifying order success message.");
        cartPage.verifyOrderSuccess();
        logger.info("'Checkout' test finished successfully.");
    }
}
