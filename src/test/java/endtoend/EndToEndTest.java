package endtoend;

import org.openqa.selenium.WebDriver;
import pages.*;
import tests.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;
import static utilities.TestData.*;
import static pages.CartPage.TotalProductPrice;
import static pages.NavigationBar.LoggedInUserNavBtn;

public class EndToEndTest extends TestBase {
    @Test
    public void E2EFlow() throws InterruptedException {
//        // Sign Up
//        NavigationBar navBar = new NavigationBar(driver);
//        navBar.ClickOnLoginAndSignUpPageNavBtn();
//
//        LoginAndSignupPage loginAndSignupPage = new LoginAndSignupPage(driver);
//        loginAndSignupPage.FillSignUpFieldAndSignUpEmailFieldWithData(VALID_NAME, UNIQUE_EMAIL);
//        loginAndSignupPage.ClickSignUpBtn();
//
//        SignupPage signupPage = getSignupPage(driver);
//        signupPage.ClickOnCreateAccountButton();
//
//        WebElement message = driver.findElement(CreatedAccountMessage);
//        String actualResult = message.getText();
//        String expectedResult = "ACCOUNT CREATED!";
//        String actualMessageColor = message.getCssValue("color");
//
//        Assert.assertEquals(actualResult, expectedResult);
//        Assert.assertEquals(actualMessageColor, "rgba(0, 128, 0, 1)");
//        signupPage.ClickOnContinueButton();
//        navBar.ClickOnLogOutBtn();

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

        String productName = PRODUCT_NAME.trim().toLowerCase();
        productPage.searchProduct(productName);
        Assert.assertTrue(productPage.isProductListContainsProductName(productName));

        // View Details And Add To Cart
        productPage.clickOnFirstProductDetails();
        ProductDetailsPage productDetailsPage = new ProductDetailsPage(driver);
        String actualPriceText = productDetailsPage.getProductPrice();
        int actualPrice = Integer.parseInt(actualPriceText.replace("Rs.", "").trim());
        productDetailsPage.setProductQuantity(PRODUCT_QUANTITY);
        productDetailsPage.clickAddToCart();
        Thread.sleep(2000);
        Assert.assertTrue(productDetailsPage.isSuccessfulMessageDisplayed());
        Assert.assertEquals(productDetailsPage.getSuccessMessageHeader(), "Added!");
        Assert.assertEquals(productDetailsPage.getSuccessMessageParagraph(), "Your product has been added to cart.");
        productDetailsPage.clickViewCartButton();
        CartPage cartPage = new CartPage(driver);
        String totalPriceText = driver.findElement(TotalProductPrice).getText();
        int totalPrice = Integer.parseInt(totalPriceText.replace("Rs.", "").trim());
        Assert.assertEquals(totalPrice, PRODUCT_QUANTITY * actualPrice);

        //Check Out
        cartPage.clickProceedToCheckout();
        cartPage.clickPlaceOrder();
        cartPage.FillCardInformation(VALID_NAME,NUMBER,CVV,EXPIRY_MONTH,EXPIRY_YEAR);
        cartPage.ClickOnPaymentButton();
        String status = cartPage.getOrderStatus();
        String successMsg = cartPage.getSuccessMessage();
        Assert.assertEquals(status, "ORDER PLACED!");
        Assert.assertEquals(successMsg, "Congratulations! Your order has been confirmed!");
    }

    private static SignupPage getSignupPage(WebDriver driver) {
        SignupPage signupPage = new SignupPage(driver);
        signupPage.EnterValidCredentials(
                'M',
                VALID_NAME,
                VALID_PASSWORD,
                BIRTH_DAY,
                BIRTH_MONTH,
                BIRTH_YEAR,
                FIRST_NAME,
                LAST_NAME,
                COMPANY,
                FIRST_ADDRESS,
                SECOND_ADDRESS,
                COUNTRY,
                STATE,
                CITY,
                ZIP_CODE,
                MOBILE
        );
        return signupPage;
    }
}
