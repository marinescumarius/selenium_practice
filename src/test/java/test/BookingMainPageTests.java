package test;

import data.Constants;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageobjects.BookingMainPage;

public class BookingMainPageTests  extends BaseTest{

    @Test(priority = 4, description ="Check the Search functionality")
    public void performASearchAndCheckResults() {
        BookingMainPage mainPage= new BookingMainPage(driver);
        mainPage.sendKeysSearchTerm(Constants.SEARCH_LOCATION);
        mainPage.pressSearchButton();
        Assert.assertTrue(mainPage.performSearch());
    }

    @Test(priority = 5, description = "Check that a predefined hotel is found in the list of returned Hotels for a SEARCH LOCATION")
    public void checkIfHotelIsInTheReturnedListOfHotelsForSearchLocationTest() {
        BookingMainPage mainPage = new BookingMainPage(driver);
        mainPage.checkIfHotelIsInTheReturnedListOfHotelsForSearchLocation(Constants.VERIFICATION_HOTEL);
    }

}
