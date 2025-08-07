package Tests;

import Pages.LoginAndSignupPage;
import Pages.NavigationBar;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;



import static Helpers.TestData.*;
import static Pages.LoginAndSignupPage.LoginErrorMsg;
import static Pages.NavigationBar.LoggedInUserNavBtn;

public class Login extends BaseTest{
    @Test(priority = 4)
    public void verify_login_with_valid_email_and_password() {
        NavigationBar navigationBar = new NavigationBar(driver);
        navigationBar.ClickOnLoginAndSignUpPageNavBtn();
        LoginAndSignupPage loginAndSignupPage = new LoginAndSignupPage(driver);
        loginAndSignupPage.FillLoginEmailAndPassword(EXISTING_EMAIL,VALID_PASSWORD);
        loginAndSignupPage.ClickLoginBtn();
        String LoggedInMessage = driver.findElement(LoggedInUserNavBtn).getText();
        System.out.println(LoggedInMessage);
        Assert.assertEquals(LoggedInMessage,"Logged in as John");
    }
    @Test(priority = 3)
    public void verify_login_with_valid_email_and_wrong_password() {
        NavigationBar navigationBar = new NavigationBar(driver);
        navigationBar.ClickOnLoginAndSignUpPageNavBtn();
        LoginAndSignupPage loginAndSignupPage = new LoginAndSignupPage(driver);
        loginAndSignupPage.FillLoginEmailAndPassword(EXISTING_EMAIL,Wrong_PASSWORD);
        loginAndSignupPage.ClickLoginBtn();
        WebElement ErrorMessage = driver.findElement(LoginErrorMsg);
        Assert.assertEquals(ErrorMessage.getText(),"Your email or password is incorrect!");
        Assert.assertEquals(ErrorMessage.getCssValue("color"), "rgba(255, 0, 0, 1)");
    }
    @Test(priority = 2)
    public void verify_login_with_wrong_email_and_valid_password() {
        NavigationBar navigationBar = new NavigationBar(driver);
        navigationBar.ClickOnLoginAndSignUpPageNavBtn();
        LoginAndSignupPage loginAndSignupPage = new LoginAndSignupPage(driver);
        loginAndSignupPage.FillLoginEmailAndPassword(Wrong_EMAIL,VALID_PASSWORD);
        loginAndSignupPage.ClickLoginBtn();
        WebElement ErrorMessage = driver.findElement(LoginErrorMsg);
        Assert.assertEquals(ErrorMessage.getText(),"Your email or password is incorrect!");
        Assert.assertEquals(ErrorMessage.getCssValue("color"), "rgba(255, 0, 0, 1)");
    }
    @Test(priority = 1)
    public void verify_login_with_wrong_email_and_wrong_password() {
        NavigationBar navigationBar = new NavigationBar(driver);
        navigationBar.ClickOnLoginAndSignUpPageNavBtn();
        LoginAndSignupPage loginAndSignupPage = new LoginAndSignupPage(driver);
        loginAndSignupPage.FillLoginEmailAndPassword(Wrong_EMAIL,Wrong_PASSWORD);
        loginAndSignupPage.ClickLoginBtn();
        WebElement ErrorMessage = driver.findElement(LoginErrorMsg);
        Assert.assertEquals(ErrorMessage.getText(),"Your email or password is incorrect!");
        Assert.assertEquals(ErrorMessage.getCssValue("color"), "rgba(255, 0, 0, 1)");
    }

}
