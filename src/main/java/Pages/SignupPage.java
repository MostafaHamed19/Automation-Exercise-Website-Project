package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class SignupPage extends BasePage {
    public SignupPage(WebDriver driver) {
        super(driver);
    }
    By MaleTitleRadio = By.cssSelector("label[for='id_gender1']");
    By FemaleTitleRadio = By.cssSelector("label[for='id_gender2']");
    By NameField = By.id("name");
    By PasswordField = By.id("password");
    By DayOfBirthField = By.id("days");
    By MonthOfBirthField = By.id("months");
    By YearOfBirthField = By.id("years");
    By FirstNameField = By.id("first_name");
    By LastNameField = By.id("last_name");
    By CompanyField = By.id("company");
    By FirstAddressField = By.id("address1");
    By LastAddressField = By.id("address2");
    By CountryField = By.id("country");
    By StateField = By.id("state");
    By CityField = By.id("city");
    By ZipcodeField = By.id("zipcode");
    By MobileNumberField = By.id("mobile_number");
    By CreateAccountButton = By.cssSelector("button[data-qa='create-account']");
    public static By CreatedAccountMessage = By.cssSelector("h2[data-qa='account-created']");

    public void EnterValidCredentials(char gender,String name,String password,int days,String months,int years,
                                      String firstname,String lastname, String company,String firstAddress,
                                      String lastAddress,String country,String state,String city,int zipcode,String mobile) {
        if(gender=='m'||gender=='M')
            driver.findElement(MaleTitleRadio).click();
        else if(gender=='f'||gender=='F')
            driver.findElement(FemaleTitleRadio).click();
        else
            System.out.println("Invalid Gender");
        driver.findElement(NameField).sendKeys(name);
        driver.findElement(PasswordField).sendKeys(password);
        select = new Select(driver.findElement(DayOfBirthField));
        select.selectByValue(String.valueOf(days));
        select = new Select(driver.findElement(MonthOfBirthField));
        select.selectByVisibleText(months);
        select = new Select(driver.findElement(YearOfBirthField));
        select.selectByValue(String.valueOf(years));
        driver.findElement(FirstNameField).sendKeys(firstname);
        driver.findElement(LastNameField).sendKeys(lastname);
        driver.findElement(CompanyField).sendKeys(company);
        driver.findElement(FirstAddressField).sendKeys(firstAddress);
        driver.findElement(LastAddressField).sendKeys(lastAddress);
        select = new Select(driver.findElement(CountryField));
        select.selectByValue(country);
        driver.findElement(StateField).sendKeys(state);
        driver.findElement(CityField).sendKeys(city);
        driver.findElement(ZipcodeField).sendKeys(String.valueOf(zipcode));
        driver.findElement(MobileNumberField).sendKeys(mobile);
    }
    public void ClickOnCreateAccountButton() {
        driver.findElement(CreateAccountButton).click();
    }

}
