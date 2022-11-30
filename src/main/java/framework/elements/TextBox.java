package framework.elements;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;

public class TextBox extends BaseElement{

    private static final Logger LOG = Logger.getLogger(TextBox.class);

    public TextBox(By locator, String name) {
        super(locator, name);
    }

    public void clear(){
        findElement().clear();
    }

    public void sendText(String text) {
        LOG.info("Send text in the textBox");
        findElement().sendKeys(text);
    }
}
