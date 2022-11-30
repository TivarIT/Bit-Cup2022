package framework.pageObjects;

import framework.driver.Browser;
import framework.elements.Button;
import framework.elements.Form;
import framework.elements.Label;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ProductsPage extends BaseForm{
    private static final Form FORM = new Form(By.id("root"), "ProductsPage");

    private static final Label UNIQUE_ELEMENT = new Label(By.xpath("//*[@id=\"header_container\"]/div[2]/span"),
            "Unique element");
    private static final Button CART_BUTTON = new Button(By.className("shopping_cart_link"), "Cart button");
    private static final Button TWITTER_BUTTON = new Button(By.xpath("//*[@id=\"page_wrapper\"]/footer/ul/li[1]/a"),
            "Twitter button");
    private static final Button SORTING_OPTIONS_BUTTON = new Button(By.xpath("//*[@id=\"header_container\"]/div[2]/div[2]/span/select"),
            "Sort option button");
    private static final Button LOW_TO_HIGH_ORDER_BUTTON = new Button(By.xpath("//*[@id=\"header_container\"]/div[2]/div[2]/span/select/option[3]"),
            "Low to high price option button");

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

    public void setLowToHighSortingOrder(){
        SORTING_OPTIONS_BUTTON.click();
        LOW_TO_HIGH_ORDER_BUTTON.click();
    }

    public boolean isListOfItemsSortedInLowToHighOrder(){
        List<WebElement> itemsList = Browser.createDriver().findElements(By.className("inventory_list"));
        List<Integer> priceList = new ArrayList<>();
        List<Integer> sortedList = new ArrayList<>();
        int listSize = itemsList.size();
        for (int i = 1; i < listSize; i++ ){
            Label itemPriceLabel = new Label(By.xpath("//*[@id=\"inventory_container\"]/div/div[\" + i + \"]/div[2]/div[2]/div"), "Label #" + i);
            String shortPrice = itemPriceLabel.getText().substring(1);
            Integer price = Integer.parseInt(shortPrice);
            priceList.add(price);
        }
        sortedList.addAll(priceList);

        sortedList = priceList.stream().sorted().collect(Collectors.toList());
        return sortedList.equals(priceList);
    }

    public void clickToCartButton(){
        CART_BUTTON.click();
    }

    public void clickTwitterButton(){
        TWITTER_BUTTON.click();
    }
}
