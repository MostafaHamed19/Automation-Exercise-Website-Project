package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage extends BasePage {
    public CartPage(WebDriver driver) {
        super(driver);
    }
    public static By TotalProductPrice = By.cssSelector(".cart_total_price");
    By ProceedToCheckout = By.cssSelector(".btn.btn-default.check_out");
    By PlaceOrder = By.cssSelector(".btn.btn-default.check_out");
    By NameOnCart = By.cssSelector("input[name='name_on_card']");
    By CardNumber = By.cssSelector("input[name='card_number']");
    By CVC = By.cssSelector("input[name='cvc']");
    By Expiration_Month=By.cssSelector("input[data-qa='expiry-month']");
    By Expiration_Year = By.cssSelector("input[data-qa='expiry-year']");
    By PayAndConfirmOrderButton = By.id("submit");
    By OrderStatus = By.cssSelector("h2[class='title text-center'] b");
    By SuccessMessage = By.cssSelector("div[class='col-sm-9 col-sm-offset-1'] p");


    public void clickProceedToCheckout() {
        driver.findElement(ProceedToCheckout).click();
    }

    public void clickPlaceOrder() {
        driver.findElement(PlaceOrder).click();
    }
    public void FillCardInformation(String name, String number, String cvv, String expiryMonth, String expiryYear) {
        driver.findElement(NameOnCart).sendKeys(name);
        driver.findElement(CardNumber).sendKeys(number);
        driver.findElement(CVC).sendKeys(cvv);
        driver.findElement(Expiration_Month).sendKeys(expiryMonth);
        driver.findElement(Expiration_Year).sendKeys(expiryYear);
    }
    public void ClickOnPaymentButton() {
        driver.findElement(PayAndConfirmOrderButton).click();
    }
    public String getOrderStatus() {
        return driver.findElement(OrderStatus).getText();
    }
    public String getSuccessMessage() {
        return driver.findElement(SuccessMessage).getText();
    }

}
