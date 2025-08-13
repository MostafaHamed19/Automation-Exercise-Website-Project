package endtoend;

import pages.*;
import tests.TestBase;
import org.testng.annotations.Test;
import utilities.TestData;
import static utilities.TestData.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class EndToEndTest extends TestBase {
    private static final Logger logger = LogManager.getLogger(EndToEndTest.class);
    @Test
    public void E2EFlow() {
        logger.info("Starting End-to-End Test flow.");

        // 1. SignUp

        logger.info("Step 1: Starting new user registration.");
        NavigationBar navBar = new NavigationBar(driver);
        navBar.ClickOnLoginAndSignUpPageNavBtn()
                .FillSignUpFieldAndSignUpEmailFieldWithData(TestData.VALID_NAME,TestData.UNIQUE_EMAIL)
                .EnterValidCredentials('M', VALID_NAME,VALID_PASSWORD,BIRTH_DAY,BIRTH_MONTH,
                        BIRTH_YEAR, FIRST_NAME,LAST_NAME,COMPANY,FIRST_ADDRESS,SECOND_ADDRESS,
                        COUNTRY,STATE,CITY,ZIP_CODE,MOBILE)
                .ClickOnCreateAccountButton()
                .VerifyCreatedAccountMessage()
                .ClickOnContinueButton();
        logger.info("User registered successfully.");

        // 2. Logout

        logger.info("Step 2: Logging out of the newly created account.");
        navBar.ClickOnLogOutBtn();
        logger.info("User logged out successfully.");

        // 3. Login

        logger.info("Step 3: Logging in with an existing account.");
        navBar.ClickOnLoginAndSignUpPageNavBtn()
                .login(EXISTING_EMAIL, VALID_PASSWORD)
                .verifyLoggedInUser(VALID_NAME);
        logger.info("User logged in successfully.");

        // 4. Search Product & View Details And Add To Cart

        logger.info("Step 4: Searching for a product and adding it to the cart.");
        int productPrice=navBar.ClickOnProductPageNavBtn()
                .searchProduct(PRODUCT_NAME)
                .verifyProductIsInList(PRODUCT_NAME)
                .clickOnFirstProductDetails()
                .verifyProductPrice()
                .setProductQuantity(PRODUCT_QUANTITY)
                .clickAddToCart()
                .verifyAddToCartMessage()
                .clickViewCartButton()
                .getProductPrice();
        logger.info("Product added to the cart successfully. ");

        //5. Check out

        logger.info("Step 5: Proceeding to checkout and placing the order.");
        CartPage cartPage = new CartPage(driver);
        cartPage.verifyTotalPrice(productPrice,PRODUCT_QUANTITY)
                .clickProceedToCheckout()
                .clickPlaceOrder()
                .FillCardInformation(VALID_NAME,NUMBER,CVV,EXPIRY_MONTH,EXPIRY_YEAR)
                .ClickOnPaymentButton()
                .verifyOrderSuccess();
        logger.info("Order placed and verified successfully.");
        logger.info("End-to-End Test finished successfully.");
    }
}
