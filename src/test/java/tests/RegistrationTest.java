package tests;

import utilities.TestData;
import pages.LoginAndSignupPage;
import pages.NavigationBar;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import static pages.LoginAndSignupPage.SignUpErrorMsg;
import static utilities.TestData.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class RegistrationTest extends TestBase {
    private static final Logger logger = LogManager.getLogger(RegistrationTest.class);
    @Test
    public void ValidRegisterTest() {
        logger.info("Starting 'Valid Registration' test.");
        NavigationBar navBar = new NavigationBar(driver);
        logger.info("Navigating to signup page and filling registration data.");
        navBar.ClickOnLoginAndSignUpPageNavBtn()
                .FillSignUpFieldAndSignUpEmailFieldWithData(TestData.VALID_NAME, TestData.EMAIL)
                .EnterValidCredentials('F', VALID_NAME, VALID_PASSWORD, BIRTH_DAY, BIRTH_MONTH,
                        BIRTH_YEAR, FIRST_NAME, LAST_NAME, COMPANY, FIRST_ADDRESS, SECOND_ADDRESS,
                        COUNTRY, STATE, CITY, ZIP_CODE, MOBILE)
                .ClickOnCreateAccountButton()
                .VerifyCreatedAccountMessage()
                .ClickOnContinueButton();
        logger.info("Verifying account creation and logging out.");
        navBar.ClickOnLogOutBtn();
        logger.info("'Valid Registration' test finished successfully.");
    }

    @Test
    public void RegisterWithExistingEmail() {
        logger.info("Starting 'Register with Existing Email' test.");
        NavigationBar navBar = new NavigationBar(driver);
        navBar.ClickOnLoginAndSignUpPageNavBtn();
        LoginAndSignupPage loginAndSignupPage = new LoginAndSignupPage(driver);
        logger.info("Attempting to register with an existing email. ");
        loginAndSignupPage.FillSignUpFieldAndSignUpEmailFieldWithData(VALID_NAME, EXISTING_EMAIL);
        WebElement errorMessage = driver.findElement(SignUpErrorMsg);
        logger.info("Asserting that the 'Email already exist' error message is visible.");
        Assert.assertTrue(errorMessage.isDisplayed(), "Error message should be visible");
        Assert.assertEquals(errorMessage.getText(), "Email Address already exist!");
        Assert.assertEquals(errorMessage.getCssValue("color"), "rgba(255, 0, 0, 1)");
        logger.info("'Register with Existing Email' test finished successfully.");
    }
}
