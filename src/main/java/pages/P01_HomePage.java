package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static drivers.DriverHolder.getDriver;

public class P01_HomePage extends PageBase {

    // TODO: constructor to intailize webdriver
    public P01_HomePage(WebDriver driver) {
        super(driver);
    }

    // TODO: define locators using By
    private final By Addtocart_Button = By.cssSelector("a[aria-label='Add “Falcon 9” to your cart']");
    private final By Viewcart_Button = By.xpath("//a[@title='View cart']");

    // TODO: public action methods
    public P01_HomePage clickAdd_toCart() {
        shortWait(getDriver()).until(ExpectedConditions.elementToBeClickable(Addtocart_Button));
        driver.findElement(this.Addtocart_Button).sendKeys(Keys.ENTER);
        return new P01_HomePage(getDriver());
    }

    public P01_HomePage clickAdd_ViewCart() {
        shortWait(getDriver()).until(ExpectedConditions.elementToBeClickable(Viewcart_Button));
        driver.findElement(this.Viewcart_Button).sendKeys(Keys.ENTER);
        return new P01_HomePage(getDriver());

    }
}