package tests;

import pages.LoginAndSignupPage;
import pages.NavigationBar;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;



import static utilities.TestData.*;
import static pages.LoginAndSignupPage.LoginErrorMsg;

public class LoginTest extends TestBase {
    @Test(priority = 4)
    public void verify_login_with_valid_email_and_password() {
        NavigationBar navigationBar = new NavigationBar(driver);
        navigationBar.ClickOnLoginAndSignUpPageNavBtn();
        LoginAndSignupPage loginAndSignupPage = new LoginAndSignupPage(driver);
        loginAndSignupPage.login(EXISTING_EMAIL,VALID_PASSWORD);
        loginAndSignupPage.verifyLoggedInUser(VALID_NAME);
    }
    @Test(priority = 3)
    public void verify_login_with_valid_email_and_wrong_password() {
        NavigationBar navigationBar = new NavigationBar(driver);
        navigationBar.ClickOnLoginAndSignUpPageNavBtn();
        LoginAndSignupPage loginAndSignupPage = new LoginAndSignupPage(driver);
        loginAndSignupPage.login(EXISTING_EMAIL,Wrong_PASSWORD);
        WebElement ErrorMessage = driver.findElement(LoginErrorMsg);
        Assert.assertEquals(ErrorMessage.getText(),"Your email or password is incorrect!");
        Assert.assertEquals(ErrorMessage.getCssValue("color"), "rgba(255, 0, 0, 1)");
    }
    @Test(priority = 2)
    public void verify_login_with_wrong_email_and_valid_password() {
        NavigationBar navigationBar = new NavigationBar(driver);
        navigationBar.ClickOnLoginAndSignUpPageNavBtn();
        LoginAndSignupPage loginAndSignupPage = new LoginAndSignupPage(driver);
        loginAndSignupPage.login(Wrong_EMAIL,VALID_PASSWORD);
        WebElement ErrorMessage = driver.findElement(LoginErrorMsg);
        Assert.assertEquals(ErrorMessage.getText(),"Your email or password is incorrect!");
        Assert.assertEquals(ErrorMessage.getCssValue("color"), "rgba(255, 0, 0, 1)");
    }
    @Test(priority = 1)
    public void verify_login_with_wrong_email_and_wrong_password() {
        NavigationBar navigationBar = new NavigationBar(driver);
        navigationBar.ClickOnLoginAndSignUpPageNavBtn();
        LoginAndSignupPage loginAndSignupPage = new LoginAndSignupPage(driver);
        loginAndSignupPage.login(Wrong_EMAIL,Wrong_PASSWORD);
        WebElement ErrorMessage = driver.findElement(LoginErrorMsg);
        Assert.assertEquals(ErrorMessage.getText(),"Your email or password is incorrect!");
        Assert.assertEquals(ErrorMessage.getCssValue("color"), "rgba(255, 0, 0, 1)");
    }

}
