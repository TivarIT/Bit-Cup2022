package framework.elements;

import org.openqa.selenium.By;

import static framework.driver.DriverUtil.clickBtnWithJS;

public class Button extends BaseElement{
    public Button(By locator, String name) {
        super(locator, name);
    }

    public void clickJS() {
        clickBtnWithJS(findElement());
    }
}
