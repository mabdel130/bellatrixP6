package testcases;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.P03_PersonalDataPage;
import pages.PageBase;
import retryTest.MyRetry;

import static drivers.DriverHolder.getDriver;
import static pages.P03_PersonalDataPage.ActualMsgformyorder;
import static util.Utility.*;

public class TC03_PersonalData extends TestBase {
    static String firstName = generateRandomFirstName();
    static String LastName = generateRandomLastName();
    static String companyName = generateRandomCompanyName();
    static String countryName = "Egypt";
    static String streetAddress = generateRandomAddress();
    static String TownorCityName = generateRandomCity();
    static String StateName = "Cairo";
    static String phoneNumber = generateRandomPhoneNumber();
    static String ZIPName = String.valueOf(generateRandomPostalCode());
    static String email = generateRandomEmail();
    static String note = generateRandomMessage();
    public static String expectedMsgformyorder="Order received";

    @Test(priority = 1, description = "Add My personalData")
    public void validate_on_My_PersonalData_P() {
        new P03_PersonalDataPage(getDriver())
                .enterFirstName(firstName)
                .enterLastName(LastName)
                .enterCompanyName(companyName)
                .enter_Country_Name(countryName)
                .enter_street_Address(streetAddress)
                .enter_Town_CityName(TownorCityName)
                . enter_State_County(StateName)
                .enter_Postcode_ZIP_Name(ZIPName)
                .enter_PhoneNumber(phoneNumber)
                .enter_Email_address(email)
                .preesCreateanaccount()
                .enter_Order_note(note)
                .clicktoPlaceorder()
                .assertonmyorderStatus();
        // capture screenshot
        PageBase.captureScreenshot(getDriver(), "Order received Page");
        Assert.assertEquals(ActualMsgformyorder,expectedMsgformyorder, "Text does not match!");

    }
}
