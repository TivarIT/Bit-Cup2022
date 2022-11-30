package test;

import framework.pageObjects.MainPage;
import framework.pageObjects.ProductsPage;
import jdk.jfr.Description;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import static framework.driver.DriverUtil.getCountOfHandles;

public class TabsTest extends BaseTest{
    private static final Logger LOG = Logger.getLogger(CheckMainPageTest.class);
    private static final String LOGIN = TEST_DATA_PROPERTIES.getProperty("login");
    private static final String PASSWORD = TEST_DATA_PROPERTIES.getProperty("password");
    private static final int TABS_COUNT = Integer.parseInt(TEST_DATA_PROPERTIES.getProperty("tabs.count"));
    private static final String MAIN_URL = CONFIGURATION_PROPERTIES.getProperty("main.page");

    private static final MainPage mainPage = new MainPage();
    private static final AuthorizationSteps authorizationSteps = new AuthorizationSteps();
    private static final ProductsPage productsPage = new ProductsPage();

    @Test
    @Description("Test #3 Open Twitter (button in the footer)")
    public void mainPageTest(){
        LOG.info("Test #3 \n Open " + MAIN_URL + " and open Twitter \n Expected result: new tab will be open.");
        Assert.assertTrue(mainPage.isMainPageOpen());
        authorizationSteps.authorizationStep(LOGIN, PASSWORD);
        Assert.assertTrue(productsPage.isProductsPageOpen());

        productsPage.clickTwitterButton();
        Assert.assertEquals(getCountOfHandles(), TABS_COUNT);
    }
}
