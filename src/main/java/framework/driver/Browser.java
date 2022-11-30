package framework.driver;

import framework.config.Config;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import java.util.Properties;

public class Browser {
    private static final Logger LOG = Logger.getLogger(Browser.class);
    private static WebDriver driver;

    private Browser() {
    }

    public static WebDriver createDriver() {
        LOG.info("Create WebDriver...");
        if (driver == null) {
            driver = BrowserFactory.createDriver();
            DriverUtil.maximize();
        }
        return driver;
    }

    public static void quit() {
        LOG.info("Close the browser and WebDriver...");
        createDriver().quit();
        driver = null;
    }
}
