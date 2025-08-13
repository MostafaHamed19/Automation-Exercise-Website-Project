package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class CartPage extends BasePage {
    public CartPage(WebDriver driver) {
        super(driver);
    }
    public CartPage(WebDriver driver, int productPrice) {
        super(driver);
        this.productPrice = productPrice;
    }

    public static By totalProductPrice = By.cssSelector(".cart_total_price");
    By ProceedToCheckout = By.cssSelector(".btn.btn-default.check_out");
    By PlaceOrder = By.cssSelector(".btn.btn-default.check_out");
    By NameOnCart = By.cssSelector("input[name='name_on_card']");
    By CardNumber = By.cssSelector("input[name='card_number']");
    By CVC = By.cssSelector("input[name='cvc']");
    By Expiration_Month=By.cssSelector("input[data-qa='expiry-month']");
    By Expiration_Year = By.cssSelector("input[data-qa='expiry-year']");
    By PayAndConfirmOrderButton = By.id("submit");
    By orderStatus = By.cssSelector("h2[class='title text-center'] b");
    By successMessage = By.cssSelector("div[class='col-sm-9 col-sm-offset-1'] p");
    private int productPrice;


    public CartPage clickProceedToCheckout() {
        driver.findElement(ProceedToCheckout).click();
        return this;
    }

    public CartPage clickPlaceOrder() {
        driver.findElement(PlaceOrder).click();
        return this;
    }
    public CartPage FillCardInformation(String name, String number, String cvv, String expiryMonth, String expiryYear) {
        driver.findElement(NameOnCart).sendKeys(name);
        driver.findElement(CardNumber).sendKeys(number);
        driver.findElement(CVC).sendKeys(cvv);
        driver.findElement(Expiration_Month).sendKeys(expiryMonth);
        driver.findElement(Expiration_Year).sendKeys(expiryYear);
        return this;
    }
    public CartPage ClickOnPaymentButton() {
        driver.findElement(PayAndConfirmOrderButton).click();
        return this;
    }
    public int getProductPrice() {
        return productPrice;
    }
    public CartPage verifyTotalPrice(int unitPrice, int quantity) {
        String totalPriceText = driver.findElement(totalProductPrice).getText();
        int actualTotal = Integer.parseInt(totalPriceText.replace("Rs.", "").trim());
        Assert.assertEquals(actualTotal, unitPrice * quantity, "Total price mismatch!");
        return this;
    }
    public void verifyOrderSuccess() {
        Assert.assertEquals(driver.findElement(orderStatus).getText(), "ORDER PLACED!");
        Assert.assertEquals(driver.findElement(successMessage).getText(), "Congratulations! Your order has been confirmed!");
    }

}
