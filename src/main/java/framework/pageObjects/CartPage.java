package framework.pageObjects;

import framework.elements.Button;
import framework.elements.Form;
import framework.elements.Label;
import org.openqa.selenium.By;

public class CartPage extends BaseForm{
    private static final Form FORM = new Form(By.id("root"), "ProductsPage");

    private static final Label UNIQUE_ELEMENT = new Label(By.className("title"), "Unique element");

    public CartPage() {
        super(FORM, "ProductsPage");
    }

    public boolean isCartPageOpen() {
        return UNIQUE_ELEMENT.isElementOnPage();
    }

    public String getItemName(String id){
        int actualId = Integer.parseInt(id) + 2;
        String stringActualId = String.valueOf(actualId);
        String itemLocator = String.format("//*[@id=\"cart_contents_container\"]/div/div[1]/div[%s]", stringActualId);
        Label itemNameLabel = new Label(By.xpath(itemLocator + "/div[2]/a/div"), "Item name");
        return itemNameLabel.getText();
    }
}
