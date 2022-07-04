package utils.waits;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BaseWait {
    private final static long FLUENT_WAIT_LONG_DURATION = 10; // in seconds
    private final static long FLUENT_WAIT_LONG_TIC_INTERVAL = 100; // in milliseconds
    private final static long FLUENT_WAIT_SHORT_DURATION = 5; // in seconds
    private final static long FLUENT_WAIT_SHORT_TIC_INTERVAL = 100; // in milliseconds

    private static FluentWait<WebDriver> myWait(WebDriver driver, long waitDuration, long ticInterval) {
        return new WebDriverWait(driver, Duration.ofSeconds(waitDuration))
            .pollingEvery(Duration.ofMillis(ticInterval));
    }

    protected static FluentWait<WebDriver> myShortWait(WebDriver driver) {
        return myWait(driver, FLUENT_WAIT_SHORT_DURATION, FLUENT_WAIT_SHORT_TIC_INTERVAL);
    }

    protected static FluentWait<WebDriver> myLongWait(WebDriver driver) {
        return myWait(driver, FLUENT_WAIT_LONG_DURATION, FLUENT_WAIT_LONG_TIC_INTERVAL);
    }
}
