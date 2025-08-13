package tests;

import utilities.TestData;
import pages.LoginAndSignupPage;
import pages.NavigationBar;
import pages.SignupPage;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import static pages.LoginAndSignupPage.SignUpErrorMsg;
import static utilities.TestData.*;

public class RegistrationTest extends TestBase {
    @Test
    public void ValidRegisterTest() {
        NavigationBar navBar = new NavigationBar(driver);
        navBar.ClickOnLoginAndSignUpPageNavBtn()
                .FillSignUpFieldAndSignUpEmailFieldWithData(TestData.VALID_NAME,TestData.UNIQUE_EMAIL)
                .EnterValidCredentials('M', VALID_NAME,VALID_PASSWORD,BIRTH_DAY,BIRTH_MONTH,
                BIRTH_YEAR, FIRST_NAME,LAST_NAME,COMPANY,FIRST_ADDRESS,SECOND_ADDRESS,
                COUNTRY,STATE,CITY,ZIP_CODE,MOBILE)
                .ClickOnCreateAccountButton()
                .VerifyCreatedAccountMessage()
                .ClickOnContinueButton();
        navBar.ClickOnLogOutBtn();
    }
    @Test
    public void RegisterWithExistingEmail() {
        NavigationBar navBar = new NavigationBar(driver);
        navBar.ClickOnLoginAndSignUpPageNavBtn();
        LoginAndSignupPage loginAndSignupPage = new LoginAndSignupPage(driver);
        loginAndSignupPage.FillSignUpFieldAndSignUpEmailFieldWithData(VALID_NAME,EXISTING_EMAIL );
        WebElement errorMessage = driver.findElement(SignUpErrorMsg);
        Assert.assertTrue(errorMessage.isDisplayed(), "Error message should be visible");
        Assert.assertEquals(errorMessage.getText(), "Email Address already exist!");
        Assert.assertEquals(errorMessage.getCssValue("color"), "rgba(255, 0, 0, 1)");
    }
}
