package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static drivers.DriverHolder.getDriver;

public class P02_ProceedtocheckoutPage extends PageBase {
    // TODO: constructor to intailize webdriver
    public P02_ProceedtocheckoutPage(WebDriver driver) {
        super(driver);
    }

    // TODO: define locators using By
    private final By Cheackout_Button = By.xpath("//a[text()='Proceed to checkout']");


    // TODO: public action methods
    public P02_ProceedtocheckoutPage click_on_Proceedtocheckout_Button() {
        shortWait(getDriver()).until(ExpectedConditions.visibilityOfElementLocated(Cheackout_Button));
        driver.findElement(this.Cheackout_Button).click();
        return new P02_ProceedtocheckoutPage(getDriver());
    }
}
