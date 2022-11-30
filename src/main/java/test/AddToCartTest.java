package test;

import framework.pageObjects.CartPage;
import framework.pageObjects.MainPage;
import framework.pageObjects.ProductsPage;
import jdk.jfr.Description;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AddToCartTest extends BaseTest{
    private static final Logger LOG = Logger.getLogger(AddToCartTest.class);
    private static final String LOGIN = TEST_DATA_PROPERTIES.getProperty("login");
    private static final String PASSWORD = TEST_DATA_PROPERTIES.getProperty("password");
    private static final String ITEM_ID = TEST_DATA_PROPERTIES.getProperty("item.id");
    private static final String ITEM_NAME = TEST_DATA_PROPERTIES.getProperty("item.name");

    private static final MainPage mainPage = new MainPage();
    private static final AuthorizationSteps authorizationSteps = new AuthorizationSteps();
    private static final ProductsPage productsPage = new ProductsPage();
    private static final CartPage cartPage = new CartPage();

    @Test
    @Description("Test #2 Add item to cart")
    public void addToCartTest(){
        LOG.info("Test #2 \n Add first item to cart \n Expected result: will add item to cart.");
        Assert.assertTrue(mainPage.isMainPageOpen());
        authorizationSteps.authorizationStep(LOGIN, PASSWORD);
        Assert.assertTrue(productsPage.isProductsPageOpen());

        productsPage.addToCart(ITEM_ID);
        productsPage.clickToCartButton();
        Assert.assertTrue(cartPage.isCartPageOpen());
        Assert.assertEquals(cartPage.getItemName(ITEM_ID), ITEM_NAME);
    }
}
