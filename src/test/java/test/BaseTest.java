package test;

import data.Constants;
import utils.webdriver.SeleniumDriver;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class BaseTest {

    protected WebDriver driver;

    @BeforeSuite
    public void setup() {
        System.out.println("-----Before Test-----");
        driver = SeleniumDriver.instantiateWebDriver();
        Assert.assertNotNull(driver, "Unable to create the driver");
        driver.navigate().to(Constants.BASE_URL);
    }

    @AfterSuite
    public void tearDown() {
        try {
            driver.close();
            driver.quit();
        } catch ( Exception e ) {
            System.out.println("Unable to close/quit the driver");
        }

    }
}
