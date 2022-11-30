package framework.elements;

import framework.driver.Browser;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import test.util.WaitUtil;

import java.time.Duration;
import java.util.NoSuchElementException;

public abstract class BaseElement {
    private static final Logger LOG = Logger.getLogger(BaseElement.class);
    private static final Duration WAIT = Duration.ofSeconds(5);

    private By locator;
    private String name;

    BaseElement(By locator, String name) {
        this.locator = locator;
        this.name = name;
    }

    public String getText() {
        LOG.info("Get text from element");
        return findElement().getText();
    }

    public void click() {
        LOG.info("Click to " + name);
        findElement().click();
    }

    protected WebElement findElement() {
        LOG.info("Find element " + name);
        WebElement element = null;
        try {
            element = Browser.createDriver().findElement(locator);
        } catch (NoSuchElementException e) {
            LOG.error("Element with name " + name + " not found on page");
        }
        return element;
    }

    public boolean isElementOnPage() {
        return !Browser.createDriver().findElements(locator).isEmpty();
    }

    public boolean isElementClose() {
        WaitUtil.waitUntilInvisibility(locator);
        return Browser.createDriver().findElements(locator).isEmpty();
    }
}
