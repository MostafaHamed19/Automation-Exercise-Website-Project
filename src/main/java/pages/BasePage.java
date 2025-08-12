package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class BasePage {
    protected WebDriver driver;
    protected Select select;
    public BasePage(WebDriver driver) {
        this.driver = driver;
    }
}