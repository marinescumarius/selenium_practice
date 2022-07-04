package test;
import data.Constants;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageobjects.BookingLogInPage;



public class BookingLogInTests extends BaseTest{



    @Test(priority=2, description = "Check that on the Sign In page we have the Sign In or Create account text")
    public void validateSignInPageTest () {
        BookingLogInPage logInPage = new BookingLogInPage(driver);
        logInPage.acceptCookies();
        Assert.assertTrue(logInPage.validateSignInPage(), "You are not on the correct page");

    }


    @Test(priority= 3, description = "Check that the sign in can be performed successfully and that the signed in username matches with the entered username")
    public void validateSignInActionTest() {
        BookingLogInPage logInPage = new BookingLogInPage(driver);
        logInPage.sendKeysUsername(Constants.USERNAME);
        logInPage.sendKeysPassword(Constants.PASSWORD);
        Assert.assertTrue(logInPage.validateSignInAction(), "Sign in could not be completed");
        logInPage.clickAccountButton();
        logInPage.clickmanageAccountButton();
        logInPage.clickManagePersonalDetailsButton();
        logInPage.clickEditButtonWebElem();
        Assert.assertEquals(logInPage.getCheckEmailAddressWebElem(), Constants.USERNAME);
    }


}
