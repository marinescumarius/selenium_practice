package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.waits.WDWait;
import utils.webelement.WEUtils;

public class BookingHomePage extends BasePage {
    @FindBy (xpath = "//div[contains(@class, 'bui-header__main')]//div[contains(@class, 'bui-header__logo')]")
    private WebElement bookingLogo;
    @FindBy (xpath = "//span[contains(text(), 'Register')]/parent::a[contains(@class, 'bui-button bui-button--secondary js-header-login-link')]")
    private WebElement registerButton;
    @FindBy (xpath = "//span[contains(text(), 'Sign in')]/parent::a[contains(@class, 'bui-button bui-button--secondary js-header-login-link')]")
    private WebElement signInButton;
    @FindBy (xpath = "//button[@id='onetrust-accept-btn-handler']")
    private static WebElement cookiesAcceptButton;

    public WebElement getSignInButton() {
        return signInButton;
    }

    public WebElement getBookingLogo() {
        return bookingLogo;
    }



    public BookingHomePage(WebDriver driver) {
        super(driver);
    }

    public boolean isHeaderLogoButtonDisplayed () {

        return WEUtils.isDisplayed(getBookingLogo());
    }

    public boolean isRegisterButtonDisplayed () {
        return WEUtils.isDisplayed(registerButton);
    }

    public boolean isSignInButtonDisplayed() {
        return WEUtils.isDisplayed(signInButton);
    }

    public boolean isCookiesAcceptButtonVisible() {
        try {
            WDWait.waitForElementToBeClickable(driver, cookiesAcceptButton);
            return  true;
        }catch (Exception ex) {
            System.out.println("Error while checking if the webelement is clickable" + ex);
            return false;
        }
    }

    public void acceptAllCookies () {
        try {
            if(isCookiesAcceptButtonVisible()) {
                cookiesAcceptButton.click();
            }
            System.out.println("Cookies were accepted");

        }catch ( Exception ex) {
            System.out.println("Error while finding the Accept Cookies webelement" + ex);
        }
    }
}
