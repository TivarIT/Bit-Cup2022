package test;

import framework.pageObjects.MainPage;
import framework.pageObjects.ProductsPage;
import jdk.jfr.Description;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CheckMainPageTest extends BaseTest{
    private static final Logger LOG = Logger.getLogger(CheckMainPageTest.class);
    private static final String LOGIN = TEST_DATA_PROPERTIES.getProperty("login");
    private static final String PASSWORD = TEST_DATA_PROPERTIES.getProperty("password");
    private static final String MAIN_URL = CONFIGURATION_PROPERTIES.getProperty("main.page");

    private static final MainPage mainPage = new MainPage();
    private static final AuthorizationSteps authorizationSteps = new AuthorizationSteps();
    private static final ProductsPage productsPage = new ProductsPage();

    @Test
    @Description("Test #1 Open Swag Labs and log in")
    public void mainPageTest(){
        LOG.info("Test #1 \n Open " + MAIN_URL + " and log in \n Expected result: after authorization Products Page will open.");
        Assert.assertTrue(mainPage.isMainPageOpen());
        authorizationSteps.authorizationStep(LOGIN, PASSWORD);
        Assert.assertTrue(productsPage.isProductsPageOpen());
    }
}
