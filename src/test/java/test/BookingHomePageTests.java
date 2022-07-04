package test;

import data.Constants;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageobjects.BookingHomePage;
import utils.waits.WDWait;
import utils.webelement.WDUtlis;


public class BookingHomePageTests extends BaseTest{

    @Test
    public void checkThePageTitle() {

        Assert.assertTrue((WDUtlis.getTitle(driver)).contains("Booking.com"), "The title does not contain Booking.com");

    }

    @Test
    public void checkTheWebPageURL() {
        Assert.assertTrue(WDUtlis.getCurrentUrl(driver).contains(Constants.BASE_URL), "The URL is not the expected one");
    }

    @Test(priority = 1)
    public void checkHeaderInfoIsDisplayed() {
        BookingHomePage homepage= new BookingHomePage(driver);
        WDWait.waitForElementToBeVisible(driver, homepage.getBookingLogo());
        homepage.acceptAllCookies();
        Assert.assertTrue(homepage.isHeaderLogoButtonDisplayed(), "The Logo Button is not displayed");
        Assert.assertTrue(homepage.isRegisterButtonDisplayed(), "The Register Button is not displayed");
        Assert.assertTrue(homepage.isSignInButtonDisplayed(), "The Sign In button is not displayed");
    }




}
