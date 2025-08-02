package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NavigationBar extends BasePage{
    public NavigationBar(WebDriver driver) {
        super(driver);
    }
    By HomePageNavBtn = By.linkText("Home");
    By LoginAndSignUpPageNavBtn = By.partialLinkText("Signup");
    By ProductsPageNavBtn = By.linkText("Products");
    By CartPageNavBtn = By.linkText("Cart");

    public void ClickOnLoginAndSignUpPageNavBtn() {
        driver.findElement(LoginAndSignUpPageNavBtn).click();
    }
}
