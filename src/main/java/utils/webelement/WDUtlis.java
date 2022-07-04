package utils.webelement;

import org.openqa.selenium.WebDriver;

public class WDUtlis {

    public static String getTitle ( WebDriver driver) {
        try {
            return driver.getTitle();
        } catch (Exception e) {
            System.out.println("unable to retrieve the title");
            return null;
        }
    }

    public static String getCurrentUrl( WebDriver driver ) {
        try {
            return driver.getCurrentUrl();
        } catch (Exception e) {
            return null;
        }
    }

    public static Boolean navigateTo( WebDriver driver, String url) {
        try {
            driver.navigate().to(url);
            return Boolean.TRUE;

        } catch (Exception e) {
            return null;
        }

    }
}
