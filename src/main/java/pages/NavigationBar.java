package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NavigationBar extends BasePage{
    public NavigationBar(WebDriver driver) {
        super(driver);
    }
    By HomePageNavBtn = By.linkText("Home");
    By LoginAndSignUpPageNavBtn = By.partialLinkText("Signup");
    By LogOutBtn = By.partialLinkText("Logout");
    By ProductsPageNavBtn = By.cssSelector("a[href='/products']");
    By CartPageNavBtn = By.linkText("Cart");
    public static By LoggedInUserNavBtn = By.partialLinkText("Logged in");

    public void ClickOnLoginAndSignUpPageNavBtn() {
        driver.findElement(LoginAndSignUpPageNavBtn).click();
    }
    public void ClickOnProductPageNavBtn(){ driver.findElement(ProductsPageNavBtn).click();}
    public void ClickOnLogOutBtn() {
        driver.findElement(LogOutBtn).click();
    }
    public void clickOnCartPageNavBtn(){ driver.findElement(CartPageNavBtn).click(); }
}
