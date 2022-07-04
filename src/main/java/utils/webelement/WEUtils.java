package utils.webelement;

import org.openqa.selenium.WebElement;

public class WEUtils {

    public static boolean isDisplayed ( WebElement element) {
        return element.isDisplayed();
    }

    public static boolean clickOnButton (WebElement element) {
        try {
            element.click();
            return true;

        }catch (Exception e) {
            return false;
        }
    }

}
