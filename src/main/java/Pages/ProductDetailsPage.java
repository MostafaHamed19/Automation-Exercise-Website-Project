package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ProductDetailsPage extends BasePage{
    public ProductDetailsPage(WebDriver driver) {
        super(driver);
    }
     By ProductName = By.cssSelector("div[class='product-information'] h2");
     By ProductPrice = By.cssSelector("div[class='product-information'] span span");
     By ProductQuantity = By.id("quantity");
     By ProductAddToCart = By.xpath("//button[normalize-space()='Add to cart']");
     By SuccessfulMessage = By.cssSelector(".modal-content");
     By SuccessMessageHeader = By.cssSelector(".modal-title.w-100");
     By SuccessMessageParagraph = By.cssSelector(".modal-body .text-center");
     public static By ViewCartButton = By.xpath("//u[normalize-space()='View Cart']");

     public String getProductName() {
         return driver.findElement(ProductName).getText();
     }
     public String getProductPrice() {
         return driver.findElement(ProductPrice).getText();
     }
     public void setProductQuantity(int quantity) {
         driver.findElement(ProductQuantity).clear();
         driver.findElement(ProductQuantity).sendKeys(String.valueOf(quantity));
     }
     public void clickAddToCart() {
         driver.findElement(ProductAddToCart).click();
     }
     public boolean isSuccessfulMessageDisplayed() {
         return driver.findElement(SuccessfulMessage).isDisplayed();
     }
     public String getSuccessMessageHeader() {
         return driver.findElement(SuccessMessageHeader).getText();
     }
     public String getSuccessMessageParagraph() {
         return driver.findElement(SuccessMessageParagraph).getText();
     }
     public void clickViewCartButton() {
         driver.findElement(ViewCartButton).click();
     }
}
