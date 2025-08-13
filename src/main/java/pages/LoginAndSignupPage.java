package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import static pages.NavigationBar.LoggedInUserNavBtn;

public class LoginAndSignupPage extends BasePage{
    public LoginAndSignupPage(WebDriver driver) {
        super(driver);
    }
    By SignUpNameField = By.cssSelector("input[data-qa='signup-name']");
    By SignUpEmailField = By.cssSelector("input[data-qa='signup-email']");
    By SignUpBtn = By.cssSelector("button[data-qa='signup-button']");
    public final static By SignUpErrorMsg = By.xpath("//p[normalize-space()='Email Address already exist!']");
    By emailField = By.cssSelector("input[data-qa='login-email']");
    By passwordField = By.cssSelector("input[data-qa='login-password']");
    By loginBtn = By.cssSelector("button[data-qa='login-button']");
    public final static By LoginErrorMsg = By.xpath("//p[normalize-space()='Your email or password is incorrect!']");

    public SignupPage FillSignUpFieldAndSignUpEmailFieldWithData(String name , String email){
        driver.findElement(SignUpNameField).sendKeys(name);
        driver.findElement(SignUpEmailField).sendKeys(email);
        driver.findElement(SignUpBtn).click();
        return new SignupPage(driver);
    }
    public LoginAndSignupPage login(String email, String password) {
        driver.findElement(emailField).sendKeys(email);
        driver.findElement(passwordField).sendKeys(password);
        driver.findElement(loginBtn).click();
        return this;
    }
    public void verifyLoggedInUser(String expectedName) {
        String actualText = driver.findElement(LoggedInUserNavBtn).getText();
        Assert.assertEquals(actualText, "Logged in as " + expectedName, "User not logged in correctly!");
    }

}
