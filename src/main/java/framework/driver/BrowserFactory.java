package framework.driver;

import framework.config.Config;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.Properties;

public class BrowserFactory {
    private static final Logger LOG = Logger.getLogger(BrowserFactory.class);

    public static WebDriver createDriver() {
        Properties configProperties =
                Config.createProperties("configuration.properties");
        WebDriver driver = null;
        switch (BrowserEnum.valueOf(configProperties.getProperty("browser.type"))) {
            case CHROME:
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                break;

            case EDGE:
                WebDriverManager.edgedriver().setup();
                driver = new EdgeDriver();
                break;

            case FIREFOX:
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                break;

            default:
                LOG.info("Browser name " + configProperties.getProperty("browser.type") + " is incorrect");
        }
        return driver;
    }
}
