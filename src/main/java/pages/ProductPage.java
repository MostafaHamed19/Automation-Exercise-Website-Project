package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;
import static pages.ProductDetailsPage.viewCartButton;

public class ProductPage extends BasePage{
    public ProductPage(WebDriver driver) {
        super(driver);
    }
    By searchBox = By.id("search_product");
    By searchBtn = By.id("submit_search");
    By ProductList= By.cssSelector(".features_items");

    public ProductPage searchProduct(String product) {
        driver.findElement(searchBox).sendKeys(product);
        driver.findElement(searchBtn).click();
        return this;
    }

    public boolean isProductListContainsProductName(String productName) {
        List<WebElement> productList = driver.findElement(ProductList).findElements(By.cssSelector(".col-sm-4"));
        List<String> names = new ArrayList<>();
        for(WebElement product : productList) {
            String Name = product.findElement(By.cssSelector("div.productinfo.text-center > p")).getText().trim().toLowerCase();
            names.add(Name);
        }
        for(String name : names) {
            if(!name.contains(productName))
                return false;
        }
        return true;
    }
    public ProductPage verifyProductIsInList(String productName) {
        String lowerName = productName.trim().toLowerCase();
        boolean isPresent = isProductListContainsProductName(lowerName);
        Assert.assertTrue(isPresent, "Product not found in list!");
        return this;
    }

    public WebElement getFirstElementText(String tag) {
        return driver.findElement(ProductList).findElement(By.cssSelector(".col-sm-4")).findElement(By.cssSelector("div.productinfo.text-center > "+tag));
    }

    public ProductDetailsPage clickOnFirstProductDetails() {
        WebElement firstProduct=driver.findElement(By.xpath("(//a[contains(text(),'View Product')])[1]"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", firstProduct);
        firstProduct.click();
        return new ProductDetailsPage(driver);
    }

    public void clickOnAddToCartFirstProduct() {
        By firstProductLocator = By.cssSelector(".btn.btn-default.add-to-cart");
        WebElement firstProduct = wait.until(ExpectedConditions.presenceOfElementLocated(firstProductLocator));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", firstProduct);
        firstProduct = wait.until(ExpectedConditions.elementToBeClickable(firstProductLocator));
        firstProduct.click();
    }

    public void clickViewCartButton() {
        driver.findElement(viewCartButton).click();
    }
}
