package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginAndSignupPage extends BasePage{
    public LoginAndSignupPage(WebDriver driver) {
        super(driver);
    }
    By SignUpNameField = By.cssSelector("input[data-qa='signup-name']");
    By SignUpEmailField = By.cssSelector("input[data-qa='signup-email']");
    By SignUpBtn = By.cssSelector("button[data-qa='signup-button']");
    public final static By SignUpErrorMsg = By.xpath("//p[normalize-space()='Email Address already exist!']");
    By LoginEmailField = By.cssSelector("input[data-qa='login-email']");
    By PasswordField = By.cssSelector("input[data-qa='login-password']");
    By LoginBtn = By.cssSelector("button[data-qa='login-button']");
    public final static By LoginErrorMsg = By.xpath("//p[normalize-space()='Your email or password is incorrect!']");

    public void FillSignUpFieldAndSignUpEmailFieldWithData(String name , String email){
        driver.findElement(SignUpNameField).sendKeys(name);
        driver.findElement(SignUpEmailField).sendKeys(email);
    }
    public void FillLoginEmailAndPassword(String email , String password){
        driver.findElement(LoginEmailField).sendKeys(email);
        driver.findElement(PasswordField).sendKeys(password);
    }
    public void ClickSignUpBtn(){
        driver.findElement(SignUpBtn).click();
    }
    public void ClickLoginBtn(){ driver.findElement(LoginBtn).click(); }
}
