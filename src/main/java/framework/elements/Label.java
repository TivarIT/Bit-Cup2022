package framework.elements;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;

public class Label extends BaseElement{
    private static final Logger LOG = Logger.getLogger(Label.class);

    public Label(By locator, String name) {
        super(locator, name);
    }

    public String getText() {
        LOG.info("Get text from element");
        return findElement().getText();
    }
}
