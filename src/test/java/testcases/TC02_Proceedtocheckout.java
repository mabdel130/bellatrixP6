package testcases;

import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;
import pages.P02_ProceedtocheckoutPage;
import pages.PageBase;
import retryTest.MyRetry;

import java.io.IOException;

import static drivers.DriverHolder.getDriver;
import static util.Utility.getExcelData;
import static util.Utility.getSingleJsonData;

public class TC02_Proceedtocheckout extends TestBase {



    @Test(priority = 1, description = "Validate RedirectTo Proceed to checkoutPage", retryAnalyzer = MyRetry.class)
    public void validateRedirectToProceedtocheckoutPage_P() {
        new P02_ProceedtocheckoutPage(getDriver()).click_on_Proceedtocheckout_Button();

        // capture screenshot
        PageBase.captureScreenshot(getDriver(),"Redirect to Proceed to checkout Page");


    }
}
