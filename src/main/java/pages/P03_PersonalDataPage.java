package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static drivers.DriverHolder.getDriver;

public class P03_PersonalDataPage extends PageBase {
    // TODO: constructor to intailize webdriver
    public P03_PersonalDataPage(WebDriver driver) {
        super(driver);
    }

    // TODO: define locators using By
    private final By FirstName_Text = By.xpath("//input[@id='billing_first_name']");
    private final By lastName_Text = By.xpath("//input[@id='billing_last_name']");

    private final By Company_Text = By.xpath("//input[@id='billing_company']");

    //private final By Country_Region_Drg_andDrop = By.xpath("//span[@id='select2-billing_country-container']");


    private final By Street_address_Text = By.xpath("//input[@id='billing_address_1']");

    private final By Town_City_Text = By.id("billing_city");

   // private final By State_County_Drg_andDrop = By.xpath("//span[@id='select2-billing_state-container']");

    private final By Postcode_ZIP_Text = By.xpath("//input[@id='billing_postcode']");

    private final By Phone_Text = By.xpath("//input[@id='billing_phone']");

    private final By Email_address_Text = By.xpath("//input[@id='billing_email']");

    private final By Createanaccount_Button = By.xpath("//input[@id='createaccount']");

    private final By Ordernotes_Text = By.xpath("//textarea[@id='order_comments']");
    private final By PlaceOrder_Button = By.xpath("//button[@id='place_order']");
    private final  By assertion_Text=By.xpath("//h1[normalize-space()='Order received']");
    private final By Country_Region_Drg_andDrop = By.xpath("//span[@id='select2-billing_country-container']");
    private final By Country_Search_Input = By.cssSelector(".select2-search__field");
    private final By State_County_Drg_andDrop = By.xpath("//span[@id='select2-billing_state-container']");

    public static String ActualMsgformyorder;

    // TODO: public action methods
    public P03_PersonalDataPage enterFirstName(String firstName) {
        shortWait(getDriver()).until(ExpectedConditions.visibilityOfElementLocated(FirstName_Text));
        driver.findElement(this.FirstName_Text).sendKeys(firstName);
        return new P03_PersonalDataPage(getDriver());
    }

    public P03_PersonalDataPage enterLastName(String LastName) {
        shortWait(getDriver()).until(ExpectedConditions.visibilityOfElementLocated(lastName_Text));
        driver.findElement(this.lastName_Text).sendKeys(LastName);
        return new P03_PersonalDataPage(getDriver());
    }

    public P03_PersonalDataPage enterCompanyName(String companyName) {
        shortWait(getDriver()).until(ExpectedConditions.visibilityOfElementLocated(Company_Text));
        driver.findElement(this.Company_Text).sendKeys(companyName);
        return new P03_PersonalDataPage(getDriver());

    }

//    public P03_PersonalDataPage enter_Country_Name(String countryName) {
//        shortWait(getDriver()).until(ExpectedConditions.visibilityOfElementLocated(Country_Region_Drg_andDrop));
//        driver.findElement(this.Country_Region_Drg_andDrop).sendKeys(countryName);
//        driver.findElement(this.Country_Region_Drg_andDrop).click();
//        return new P03_PersonalDataPage(getDriver());
//
//    }

    public P03_PersonalDataPage enter_street_Address(String streetAddress) {
       longWait(getDriver()).until(ExpectedConditions.visibilityOfElementLocated(Street_address_Text));
        driver.findElement(this.Street_address_Text).sendKeys(streetAddress);
        return new P03_PersonalDataPage(getDriver());

    }

    public P03_PersonalDataPage enter_Town_CityName(String TownorCityName) {
        shortWait(getDriver()).until(ExpectedConditions.visibilityOfElementLocated(Town_City_Text));
        driver.findElement(this.Town_City_Text).sendKeys(TownorCityName);
        return new P03_PersonalDataPage(getDriver());

    }


//    public P03_PersonalDataPage enter_State_CountryName(String StateName) {
//        shortWait(getDriver()).until(ExpectedConditions.visibilityOfElementLocated(State_County_Drg_andDrop));
//        driver.findElement(this.State_County_Drg_andDrop).sendKeys(StateName);
//        driver.findElement(this.State_County_Drg_andDrop).click();
//        return new P03_PersonalDataPage(getDriver());
//
//    }

    public P03_PersonalDataPage enter_Postcode_ZIP_Name(String ZIPName) {
        shortWait(getDriver()).until(ExpectedConditions.visibilityOfElementLocated(Postcode_ZIP_Text));
        driver.findElement(this.Postcode_ZIP_Text).sendKeys(ZIPName);
        return new P03_PersonalDataPage(getDriver());

    }


    public P03_PersonalDataPage enter_PhoneNumber(String phoneNumber) {
        shortWait(getDriver()).until(ExpectedConditions.visibilityOfElementLocated(Phone_Text));
        driver.findElement(this.Phone_Text).sendKeys(phoneNumber);
        return new P03_PersonalDataPage(getDriver());

    }


    public P03_PersonalDataPage enter_Email_address(String email) {
        shortWait(getDriver()).until(ExpectedConditions.visibilityOfElementLocated(Email_address_Text));
        driver.findElement(this.Email_address_Text).sendKeys(email);
        return new P03_PersonalDataPage(getDriver());

    }

    public P03_PersonalDataPage preesCreateanaccount() {
        shortWait(getDriver()).until(ExpectedConditions.visibilityOfElementLocated(Createanaccount_Button));
        driver.findElement(this.Createanaccount_Button).click();
        return new P03_PersonalDataPage(getDriver());

    }


    public P03_PersonalDataPage enter_Order_note(String note) {
        shortWait(getDriver()).until(ExpectedConditions.visibilityOfElementLocated(Ordernotes_Text));
        driver.findElement(this.Ordernotes_Text).sendKeys(note);
        return new P03_PersonalDataPage(getDriver());

    }

    public P03_PersonalDataPage clicktoPlaceorder() {
        shortWait(getDriver()).until(ExpectedConditions.visibilityOfElementLocated(PlaceOrder_Button));
        driver.findElement(this.PlaceOrder_Button).click();
        return new P03_PersonalDataPage(getDriver());

    }
    public P03_PersonalDataPage assertonmyorderStatus() {
        ActualMsgformyorder=shortWait(getDriver()).until(ExpectedConditions.visibilityOfElementLocated(assertion_Text)).getText();
        return new P03_PersonalDataPage(getDriver());

    }
    public P03_PersonalDataPage enter_Country_Name(String countryName) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // 1. Click the country dropdown to open it
        WebElement countryDropdown = wait.until(ExpectedConditions.elementToBeClickable(Country_Region_Drg_andDrop));
        countryDropdown.click();

        // 2. Find and interact with the search input field
        WebElement searchInput = wait.until(ExpectedConditions.visibilityOfElementLocated(Country_Search_Input));
        searchInput.sendKeys(countryName);

        // 3. Select the matching option
        searchInput.sendKeys(Keys.ENTER);

        return this;
    }

    // Similar approach for state/county selection
    public P03_PersonalDataPage enter_State_County(String stateName) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        WebElement stateDropdown = wait.until(ExpectedConditions.elementToBeClickable(State_County_Drg_andDrop));
        stateDropdown.click();

        WebElement searchInput = wait.until(ExpectedConditions.visibilityOfElementLocated(Country_Search_Input));
        searchInput.sendKeys(stateName);
        searchInput.sendKeys(Keys.ENTER);

        return this;
    }

}