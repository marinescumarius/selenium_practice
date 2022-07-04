package utils.waits;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;


public class WDWait extends BaseWait{

    public  static void waitForElementToBeVisible(WebDriver driver, WebElement e){

        try{
            myShortWait(driver).until(ExpectedConditions.visibilityOf(e));
        }catch (NoSuchElementException eex){
            System.out.println("The element could not be found in 5 seconds" + eex);
        }catch (Exception ex ){
            System.out.println("The page exceeded 5 seconds to load" + ex);
        }
    }
    public static Boolean waitForPageTitleToContainText(WebDriver driver, String partialText) {
        try {
            return myLongWait(driver).until(ExpectedConditions.titleContains(partialText));
        } catch (TimeoutException e) {
            return null;
        }
    }

    public  static void waitForElementToBeClickable(WebDriver driver, WebElement e){

        try{
            myShortWait(driver).until(ExpectedConditions.elementToBeClickable(e));
        }catch (NoSuchElementException eex){
            System.out.println("The element could not be found in 5 seconds" + eex);
        }catch (Exception ex ){
            System.out.println("The page exceeded 5 seconds to load" + ex);
        }
    }


}
