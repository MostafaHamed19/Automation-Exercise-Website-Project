package E2E;

import Helpers.TestData;
import Pages.*;
import Tests.BaseTest;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import static Helpers.TestData.*;
import static Pages.CartPage.TotalProductPrice;
import static Pages.NavigationBar.LoggedInUserNavBtn;
import static Pages.SignupPage.CreatedAccountMessage;

public class e2eScenario extends BaseTest {
    @Test
        public void E2EFlow() throws InterruptedException {
//            // Sign Up
//            NavigationBar navBar = new NavigationBar(driver);
//            navBar.ClickOnLoginAndSignUpPageNavBtn();
//
//            LoginAndSignupPage loginAndSignupPage = new LoginAndSignupPage(driver);
//            String CreatedEmail = UNIQUE_EMAIL;
//            loginAndSignupPage.FillSignUpFieldAndSignUpEmailFieldWithData(VALID_NAME,CreatedEmail);
//            loginAndSignupPage.ClickSignUpBtn();
//
//            SignupPage signupPage = new SignupPage(driver);
//            signupPage.EnterValidCredentials(
//                    'M',
//                    VALID_NAME,
//                    VALID_PASSWORD,
//                    BIRTH_DAY,
//                    BIRTH_MONTH,
//                    BIRTH_YEAR,
//                    FIRST_NAME,
//                    LAST_NAME,
//                    COMPANY,
//                    FIRST_ADDRESS,
//                    SECOND_ADDRESS,
//                    COUNTRY,
//                    STATE,
//                    CITY,
//                    ZIP_CODE,
//                    MOBILE
//            );
//            signupPage.ClickOnCreateAccountButton();
//
//            WebElement message = driver.findElement(CreatedAccountMessage);
//            String actualResult = message.getText();
//            String expectedResult = "ACCOUNT CREATED!";
//            String actualMessageColor = message.getCssValue("color");
//
//            Assert.assertEquals(actualResult, expectedResult);
//            Assert.assertEquals(actualMessageColor, "rgba(0, 128, 0, 1)");

            // Login

            NavigationBar navBar = new NavigationBar(driver);
            navBar.ClickOnLoginAndSignUpPageNavBtn();
            LoginAndSignupPage loginAndSignupPage = new LoginAndSignupPage(driver);
            loginAndSignupPage.FillLoginEmailAndPassword(EXISTING_EMAIL, VALID_PASSWORD);
            loginAndSignupPage.ClickLoginBtn();

            String loggedInMessage = driver.findElement(LoggedInUserNavBtn).getText();
            System.out.println(loggedInMessage);
            Assert.assertEquals(loggedInMessage, "Logged in as John");

            // Search For A Product

            navBar.ClickOnProductPageNavBtn();
            ProductPage productPage = new ProductPage(driver);

            String productName = "Cotton".trim().toLowerCase();
            productPage.searchProduct(productName);
            Assert.assertTrue(productPage.isProductListContainsProductName(productName));

            // View Details And Add To Cart
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

            //Check Out
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
