package testcases;

import com.aventstack.chaintest.plugins.ChainTestListener;
import com.github.javafaker.Faker;
import drivers.DriverFactory;
import listeners.Listener;
import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;

import java.awt.*;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import static drivers.DriverHolder.getDriver;
import static drivers.DriverHolder.setDriver;
import static pages.PageBase.quitBrowser;
import static util.Utility.openBrowserNetworkTab;

@Listeners({ChainTestListener.class, Listener.class})
public class TestBase {
    SoftAssert softAssert = new SoftAssert();

    Faker faker = new Faker();
    private static String PROJECT_NAME = null;
    private static String PROJECT_URL = null;
    static Properties prop;
    static FileInputStream readProperty;
    protected String lang;
    protected Logger log;

    @BeforeSuite
    public void beforeSuite() throws Exception {
        DOMConfigurator.configure(System.getProperty("user.dir") + "/log4j.xml");
        log = Logger.getLogger(getClass());
        setProjectDetails();
    }

    private void setProjectDetails() throws IOException {
        // TODO: Step1: define object of properties file
        readProperty = new FileInputStream(
                System.getProperty("user.dir") + "/src/test/resources/properties/environment.properties");
        prop = new Properties();
        prop.load(readProperty);

        // define project name from properties file
        PROJECT_NAME = prop.getProperty("projectName");
        PROJECT_URL = prop.getProperty("url");
    }


    @Parameters("browsername")
    @BeforeTest
    public void OpenBrower(@Optional String browsername) throws AWTException {
        lang=browsername;
        // setDriver(DriverFactory.getNewInstance(browsername));
        setDriver(DriverFactory.getNewInstance(browsername));


        getDriver().get(PROJECT_URL);

        // open browser network
        //openBrowserNetworkTab();
    }

    @AfterTest
    public void TearDown() {

        quitBrowser(getDriver());
    }

    @AfterSuite
    public void afterSuite() throws Exception {
    }
}
