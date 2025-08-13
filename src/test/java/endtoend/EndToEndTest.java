package endtoend;

import pages.*;
import tests.TestBase;
import org.testng.annotations.Test;
import utilities.TestData;

import static utilities.TestData.*;

public class EndToEndTest extends TestBase {
    @Test
    public void E2EFlow() {
        // 1. SignUp

        NavigationBar navBar = new NavigationBar(driver);
        navBar.ClickOnLoginAndSignUpPageNavBtn()
                .FillSignUpFieldAndSignUpEmailFieldWithData(TestData.VALID_NAME,TestData.UNIQUE_EMAIL)
                .EnterValidCredentials('M', VALID_NAME,VALID_PASSWORD,BIRTH_DAY,BIRTH_MONTH,
                        BIRTH_YEAR, FIRST_NAME,LAST_NAME,COMPANY,FIRST_ADDRESS,SECOND_ADDRESS,
                        COUNTRY,STATE,CITY,ZIP_CODE,MOBILE)
                .ClickOnCreateAccountButton()
                .VerifyCreatedAccountMessage()
                .ClickOnContinueButton();

        // 2. Logout
                navBar.ClickOnLogOutBtn();

        // 3. Login

        navBar.ClickOnLoginAndSignUpPageNavBtn()
                .login(EXISTING_EMAIL, VALID_PASSWORD)
                .verifyLoggedInUser(VALID_NAME);

        // 4. Search Product & View Details And Add To Cart

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

        //5. Check out

        CartPage cartPage = new CartPage(driver);
        cartPage.verifyTotalPrice(productPrice,PRODUCT_QUANTITY)
                .clickProceedToCheckout()
                .clickPlaceOrder()
                .FillCardInformation(VALID_NAME,NUMBER,CVV,EXPIRY_MONTH,EXPIRY_YEAR)
                .ClickOnPaymentButton()
                .verifyOrderSuccess();
    }
}
