package test;

import framework.config.Config;
import framework.driver.Browser;
import org.apache.log4j.Logger;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.util.Properties;

import static framework.driver.DriverUtil.goToUrl;

public class BaseTest {
    private static final Logger LOG = Logger.getLogger(BaseTest.class);
    protected static final Properties TEST_DATA_PROPERTIES =
            Config.createProperties("testData.properties");
    protected static final Properties CONFIGURATION_PROPERTIES =
            Config.createProperties("configuration.properties");
    private static final String URL_MAIN_PAGE = CONFIGURATION_PROPERTIES.getProperty("main.page");

    @BeforeMethod
    public void writeRunTestToLog() {
        LOG.info("Run the test");
        LOG.info("Navigate to URL " + URL_MAIN_PAGE);
        goToUrl(URL_MAIN_PAGE);
    }

    @AfterMethod
    public void writeCompleteTestToLog() {
        LOG.info("Test completed");
        Browser.quit();
    }
}
