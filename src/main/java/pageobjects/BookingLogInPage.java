package pageobjects;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.waits.WDWait;
import utils.webelement.WEUtils;

import java.time.Duration;


public class BookingLogInPage extends BasePage {


    @FindBy(xpath = "//div[normalize-space()= 'Sign in or create an account']")
    private WebElement signInText;
    @FindBy(xpath = "//input[@type='email']")
    private WebElement username;
    @FindBy(xpath = "//button[@type='submit']")
    private WebElement submitButton;
    @FindBy(xpath = "//div[@class='page-header']//h1[contains(text(), 'Enter your password')]")
    private WebElement enterYourPasswordText;
    @FindBy(xpath = "//input[@type='password']")
    private WebElement password;
    @FindBy(xpath = "//div[@class='bui-header__logo']")
    private WebElement mainPageLogo;
    @FindBy (xpath="//a[@aria-label='Open the profile menu']")
    private WebElement accountButton;

    @FindBy (xpath="//div[@data-bui-ref='dropdown-slot']//ul/li[1]//a")
    private WebElement manageAccountButtonWebElem;

    @FindBy (xpath = "//div[@id='mysettings_personal_details_title']")
    private WebElement managePersonalDetailsButton;
    @FindBy (xpath = "//input[@name='new_email']")
    private WebElement checkEmailAddressWebElem;
    @FindBy (xpath = "//button[@data-ga-label='Edit section: email']")
    private WebElement editButtonWebElem;

    public BookingLogInPage(WebDriver driver) {
        super(driver);

    }
    public void clickEditButtonWebElem() {
        try {
            WEUtils.clickOnButton(editButtonWebElem);
        } catch (Exception e){
            System.out.println("Could not press Edit Email button");
        }
    }
    public String getCheckEmailAddressWebElem () {
        try {
            WDWait.waitForElementToBeVisible(driver, checkEmailAddressWebElem);
            return checkEmailAddressWebElem.getAttribute("value");
        } catch (Exception ex) {
            System.out.println("Could not get the email address value from Personal Details");
            return null;
        }
    }
    public void clickManagePersonalDetailsButton () {
        try {
            WEUtils.clickOnButton(managePersonalDetailsButton);
        }catch ( Exception ex) {
            System.out.println("Could not click on Manage Personal Details Button");
        }
    }

    public void clickmanageAccountButton () {
       try{
           WEUtils.clickOnButton(manageAccountButtonWebElem);
       }catch (Exception ex) {
           System.out.println("Could not click on Manage Account Button");
       }
    }

    public void clickAccountButton () {
        try {
            WEUtils.clickOnButton(accountButton);
        }catch (Exception ex) {
            System.out.println("Could not click on Account Button");
        }
    }



    public void acceptCookies() {
        BookingHomePage homepage = new BookingHomePage(driver);
        try {
            homepage.acceptAllCookies();
        } catch (Exception ex) {
            System.out.println("Could not accept cookies");
        }

    }
    public boolean validateSignInPage() {
        BookingHomePage homepage = new BookingHomePage(driver);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        try {
            WDWait.waitForElementToBeClickable(driver, homepage.getSignInButton());

            if (WEUtils.isDisplayed(homepage.getSignInButton())) {
                homepage.getSignInButton().click();
            }
            return  true;

        } catch (Exception ex) {
            System.out.println("The sign in button was not displayed");
            return false;
        }

    }

    public boolean validateSignInAction() {
    try {
        WDWait.waitForPageTitleToContainText(driver, "Official Site");
        return WEUtils.isDisplayed(mainPageLogo);
    } catch (Exception ex) {
        System.out.println("Sign in could not be completed" + ex);
        return false;
    }
    }

    public void sendKeysUsername(String user) {
        try {
            WDWait.waitForElementToBeVisible(driver, username);
            username.sendKeys(user);
            WEUtils.clickOnButton(submitButton);
        } catch (Exception ex) {
            System.out.println("Could not send the username");
        }

    }

    public void sendKeysPassword (String pass) {
        try {
            WDWait.waitForElementToBeVisible(driver, password);
            password.sendKeys(pass);
            WEUtils.clickOnButton(submitButton);
        } catch ( Exception ex) {
            System.out.println("Could not send the password");
        }

    }




}
