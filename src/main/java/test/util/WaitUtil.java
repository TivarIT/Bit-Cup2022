package test.util;

import framework.driver.Browser;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class WaitUtil {
    public static final WebDriverWait WAIT = new WebDriverWait(Browser.createDriver(), Duration.ofSeconds(5));

    public static boolean waitUntilInvisibility(By locator){
       return WAIT.until(ExpectedConditions.invisibilityOfElementLocated(locator));
    }

    public static Alert waitUntilAlertIsPresent(){
        return WAIT.until(ExpectedConditions.alertIsPresent());
    }
}
