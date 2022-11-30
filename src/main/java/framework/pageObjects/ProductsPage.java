package framework.pageObjects;

import framework.elements.Button;
import framework.elements.Form;
import framework.elements.Label;
import org.openqa.selenium.By;

public class ProductsPage extends BaseForm{
    private static final Form FORM = new Form(By.id("root"), "ProductsPage");

    private static final Label UNIQUE_ELEMENT = new Label(By.xpath("//*[@id=\"header_container\"]/div[2]/span"),
            "Unique element");
    private static final Button CART_BUTTON = new Button(By.className("shopping_cart_link"), "Cart button");
    private static final Button TWITTER_BUTTON = new Button(By.xpath("//*[@id=\"page_wrapper\"]/footer/ul/li[1]/a"),
            "Twitter button");

    public ProductsPage() {
        super(FORM, "ProductsPage");
    }

    public boolean isProductsPageOpen() {
        return UNIQUE_ELEMENT.isElementOnPage();
    }

    public void addToCart(String id){
        String itemLocator = String.format("//*[@id=\"inventory_container\"]/div/div[%s]", id);
        Button addToCartButton = new Button(By.xpath(itemLocator + "/div[2]/div[2]/button[contains(text(), 'Add to cart')]"),
                "Add to cart button");
        addToCartButton.click();
    }

    public void clickToCartButton(){
        CART_BUTTON.click();
    }

    public void clickTwitterButton(){
        TWITTER_BUTTON.click();
    }
}
