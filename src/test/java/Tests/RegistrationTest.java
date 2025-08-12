package tests;

import utilities.TestData;
import pages.LoginAndSignupPage;
import pages.NavigationBar;
import pages.SignupPage;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import static pages.LoginAndSignupPage.SignUpErrorMsg;
import static pages.SignupPage.CreatedAccountMessage;
import static utilities.TestData.*;

public class RegistrationTest extends TestBase {
    @Test
    public void ValidRegisterTest() {
        NavigationBar navBar = new NavigationBar(driver);
        navBar.ClickOnLoginAndSignUpPageNavBtn();
        LoginAndSignupPage loginAndSignupPage = new LoginAndSignupPage(driver);
        loginAndSignupPage.FillSignUpFieldAndSignUpEmailFieldWithData(TestData.VALID_NAME,TestData.UNIQUE_EMAIL);
        loginAndSignupPage.ClickSignUpBtn();
        SignupPage signupPage = new SignupPage(driver);
        signupPage.EnterValidCredentials('M', VALID_NAME,VALID_PASSWORD,BIRTH_DAY,BIRTH_MONTH,
                BIRTH_YEAR, FIRST_NAME,LAST_NAME,COMPANY,FIRST_ADDRESS,SECOND_ADDRESS,
                COUNTRY,STATE,CITY,ZIP_CODE,MOBILE);
        signupPage.ClickOnCreateAccountButton();
        WebElement message = driver.findElement(CreatedAccountMessage);
        String ActualResult = message.getText();
        String ExpectedResult = "ACCOUNT CREATED!";
        String ActualMessageColor = message.getCssValue("color");
        Assert.assertEquals(ActualResult,ExpectedResult);
        Assert.assertEquals(ActualMessageColor,"rgba(0, 128, 0, 1)");
    }
    @Test
    public void RegisterWithExistingEmail() {
        NavigationBar navBar = new NavigationBar(driver);
        navBar.ClickOnLoginAndSignUpPageNavBtn();
        LoginAndSignupPage loginAndSignupPage = new LoginAndSignupPage(driver);
        loginAndSignupPage.FillSignUpFieldAndSignUpEmailFieldWithData(VALID_NAME,EXISTING_EMAIL );
        loginAndSignupPage.ClickSignUpBtn();
        WebElement errorMessage = driver.findElement(SignUpErrorMsg);
        Assert.assertTrue(errorMessage.isDisplayed(), "Error message should be visible");
        Assert.assertEquals(errorMessage.getText(), "Email Address already exist!");
        Assert.assertEquals(errorMessage.getCssValue("color"), "rgba(255, 0, 0, 1)");
    }
}
