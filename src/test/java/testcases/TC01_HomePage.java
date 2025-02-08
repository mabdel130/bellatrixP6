package testcases;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.P01_HomePage;
import retryTest.MyRetry;

import static drivers.DriverHolder.getDriver;

//@Epic("Registration")
//@Story("Registation Story")
public class TC01_HomePage extends TestBase {

    String checkoutPage="https://demos.bellatrix.solutions/";
    @Test(priority = 1,description = "Check Add to my cart and view my Cart Page ",retryAnalyzer = MyRetry.class)
    public void validateAddtocartandViewMycart_P(){
        new P01_HomePage(getDriver()).clickAdd_toCart().clickAdd_ViewCart();

        // assert navigation to cartPage
        Assert.assertEquals(getDriver().getCurrentUrl(),checkoutPage);
    }


}
