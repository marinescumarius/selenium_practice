package pageobjects;

import data.Constants;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.waits.WDWait;
import utils.webelement.WDUtlis;
import utils.webelement.WEUtils;

import java.util.List;


public class BookingMainPage extends BasePage{

    @FindBy (xpath = "//input[@type='search']")
    private  WebElement searchInputBox;
    @FindBy (xpath = "//div[@class='sb-date-field__display'][@data-placeholder='Check-in']")
    private WebElement checkInDate;
    @FindBy (xpath = "//div[@class='sb-date-field__display'][@data-placeholder='Check-out']")
    private WebElement checkOutDate;
    @FindBy (xpath = "//button[@data-sb-id='main']")
    private WebElement searchButton;

    ////ul[@class='_2i9Agl37xS2G1XMjr4L2kX']/li[1]/button
//    @FindBy (xpath = "//a[@href='https://account.booking.com/oauth2/authorize?aid=304142;client_id=d1cDdLj40ACItEtxJLTo;redirect_uri=https%3A%2F%2Faccount.booking.com%2Fsettings%2Foauth_callback;response_type=code;state=eyJteXNldHRpbmdzX3BhdGgiOiIvbXlzZXR0aW5ncyIsImFpZCI6MzA0MTQyfQ']")
//    private WebElement manageAccount;
    public BookingMainPage(WebDriver driver) {
        super(driver);
    }


    public void sendKeysSearchTerm( String key) {
        try{
            WDWait.waitForElementToBeVisible(driver, searchInputBox);
            searchInputBox.sendKeys(key);
        } catch (Exception ex) {
            System.out.println("Could not enter the search term");
        }

    }

    public void pressSearchButton() {
        try {
   //         driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            WDWait.waitForElementToBeClickable(driver, searchButton);
            WEUtils.clickOnButton(searchButton);
        } catch ( Exception ex) {
            System.out.println("Could not click on search button");
        }

    }
    public boolean performSearch() {
        try {
            WDWait.waitForPageTitleToContainText(driver, Constants.SEARCH_LOCATION);
            return WDUtlis.getTitle(driver).contains(Constants.SEARCH_LOCATION) ;

        } catch (Exception ex) {
            System.out.println("Could not perform search");
            return  false;
        }

    }

    public boolean checkIfHotelIsInTheReturnedListOfHotelsForSearchLocation (String checkedHotel)  {
        List<WebElement> listOfHotels = driver.findElements(By.xpath("//div[@data-testid='title']"));
        boolean flag=false;
        for (WebElement hotel : listOfHotels) {
            if(hotel.equals(checkedHotel)){
                flag=true;
                break;
            }
            else flag=false;
        } return flag;

    }
}


