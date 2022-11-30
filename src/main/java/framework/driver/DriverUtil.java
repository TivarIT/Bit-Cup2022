package framework.driver;

import org.apache.log4j.Logger;
import org.openqa.selenium.*;
import test.util.WaitUtil;
import java.util.Set;

public class DriverUtil {
    private static final Logger LOG = Logger.getLogger(DriverUtil.class);
    private static final JavascriptExecutor JS = (JavascriptExecutor) Browser.createDriver();
    private static final String ORIGINAL_WINDOW = getHandle();

    public static void switchToWindow(String name){
        Browser.createDriver().switchTo().window(name);
    }

    public static Set<String> getSetOfHandles(){
        return Browser.createDriver().getWindowHandles();
    }

    public static String getHandle(){
        return Browser.createDriver().getWindowHandle();
    }

    public static void maximize() {
        LOG.info("Maximizing the browser window");
        Browser.createDriver().manage().window().maximize();
    }

    public static void goToUrl(String url) {
        LOG.info("Opening the URL " + url);
        Browser.createDriver().get(url);
    }

    public static void closeTab() {
        LOG.info("Close tab");
        Browser.createDriver().close();
    }

    public static void goToNewTab(){
        LOG.info("Switch driver to new tab");
        for (String windowHandle : getSetOfHandles()) {
            if(!ORIGINAL_WINDOW.contentEquals(windowHandle)) {
                switchToWindow(windowHandle);
                break;
            }
        }
    }

    public static void closeTabAndReturn(){
        LOG.info("Close tab and switch driver to previous tab");
        for (String windowHandle : getSetOfHandles()) {
            if (!windowHandle.equals(ORIGINAL_WINDOW)) {
                switchToWindow(windowHandle);
                closeTab();
            }
        }
        switchToWindow(ORIGINAL_WINDOW);
    }

    public static void goToPreviousTab() {
        LOG.info("Go to back page");
        for (String windowHandle : getSetOfHandles()) {
            if (!windowHandle.equals(ORIGINAL_WINDOW)) {
                switchToWindow(windowHandle);
            }
        }
       switchToWindow(ORIGINAL_WINDOW);
    }

    public static int getCountOfHandles(){
        return getSetOfHandles().size();
    }

    protected static Alert waitAlert() {
        LOG.info("Wait alert");
        return WaitUtil.waitUntilAlertIsPresent();
    }

    public static String getTextAlert() {
        LOG.info("Get text from the alert");
        return waitAlert().getText();
    }

    public static void clickBtnOkOnAlert() {
        LOG.info("Click the OK button on the alert");
        waitAlert().accept();
    }

    public static boolean isAlertPresent() {
        LOG.info("Checking if there is an alert");
        try {
            Browser.createDriver().switchTo().alert();
            return true;
        } catch (NoAlertPresentException Ex) {
            return false;
        }
    }

    public static void printTextToAlert(String text) {
        LOG.info("Print text " + text + " to Alert");
        Alert alert = waitAlert();
        alert.sendKeys(text);
        alert.accept();
    }

    public static void goToFrame(String frame) {
        LOG.info("Go to the frame " + frame);
        Browser.createDriver().switchTo().frame(frame);
    }

    public static void goToNestedFrame(int frame) {
        LOG.info("Go to the frame " + frame);
        Browser.createDriver().switchTo().frame(frame);
    }


    public static void goToDefaultFrame() {
        LOG.info("Return to the main frame");
        Browser.createDriver().switchTo().defaultContent();
    }

    public static void clickBtnWithJS(WebElement element) {
        LOG.info("Clicking the button using the javascript method");
        JS.executeScript("arguments[0].click();", element);
    }
}
