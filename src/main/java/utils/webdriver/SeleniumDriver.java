package utils.webdriver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class SeleniumDriver {
    private static WebDriver driver;
    public static WebDriver instantiateWebDriver () {

       // WebDriverManager.chromedriver().setup();
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/src/test/resources/webdrivers/chromedriver");
        ChromeOptions chromeOptions = new ChromeOptions();
        driver= new ChromeDriver(chromeOptions);
        if(driver != null) {
            driver.manage().window().maximize();
        }
        return driver;
    }

}
