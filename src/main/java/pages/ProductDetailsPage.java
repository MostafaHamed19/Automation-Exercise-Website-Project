package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

public class ProductDetailsPage extends BasePage{
    public ProductDetailsPage(WebDriver driver) {
        super(driver);
    }
     By productName = By.cssSelector("div[class='product-information'] h2");
     By productPrice = By.cssSelector("div[class='product-information'] span span");
     By quantityField = By.id("quantity");
     By productAddToCart = By.xpath("//button[normalize-space()='Add to cart']");
     By successfulMessage = By.cssSelector(".modal-content");
     By successMessageHeader = By.cssSelector(".modal-title.w-100");
     By successMessageParagraph = By.cssSelector(".modal-body .text-center");
     public static By viewCartButton = By.xpath("//u[normalize-space()='View Cart']");
     private int currentProductPrice;

     public String getProductName() {
         return driver.findElement(productName).getText();
     }
     public String getProductPrice() {
         return driver.findElement(productPrice).getText();
     }
     public ProductDetailsPage setProductQuantity(int quantity) {
         driver.findElement(quantityField).clear();
         driver.findElement(quantityField).sendKeys(String.valueOf(quantity));
         return this;
     }
     public ProductDetailsPage clickAddToCart() {
         driver.findElement(productAddToCart).click();
         wait.until(ExpectedConditions.visibilityOfElementLocated(successMessageHeader));
         return this;
     }
     public boolean isSuccessfulMessageDisplayed() {
         return driver.findElement(successfulMessage).isDisplayed();
     }
     public CartPage clickViewCartButton() {
         driver.findElement(viewCartButton).click();
         return new CartPage(driver, currentProductPrice);
     }

    public ProductDetailsPage verifyProductPrice() {
        String priceText = driver.findElement(productPrice).getText();
        currentProductPrice = Integer.parseInt(priceText.replace("Rs.", "").trim());
        Assert.assertTrue(currentProductPrice > 0, "Invalid product price!");
        return this;
    }
    public ProductDetailsPage verifyAddToCartMessage() {
        Assert.assertEquals(driver.findElement(successMessageHeader).getText(), "Added!");
        Assert.assertEquals(driver.findElement(successMessageParagraph).getText(), "Your product has been added to cart.");
        return this;
    }

}
