package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class ProductPage extends BasePage{
    public ProductPage(WebDriver driver) {
        super(driver);
    }
    By SearchField = By.id("search_product");
    By SearchButton = By.id("submit_search");
    By ProductList= By.cssSelector(".features_items");

    public void searchProduct(String product) {
        driver.findElement(SearchField).sendKeys(product);
        driver.findElement(SearchButton).click();
    }
    public boolean isProductListContainsProductName(String productName) {
        List<WebElement> productList = driver.findElement(ProductList).findElements(By.cssSelector(".col-sm-4"));
        List<String> names = new ArrayList<>();
        for(WebElement product : productList) {
            String Name = product.findElement(By.cssSelector("div.productinfo.text-center > p")).getText().trim().toLowerCase();
            names.add(Name);
            System.out.println(Name);
        }
        for(String name : names) {
            if(!name.contains(productName))
                return false;
        }
        return true;
    }
}
