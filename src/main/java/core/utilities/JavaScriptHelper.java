package core.utilities;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Javascript related helper methods would reside here
 */
public class JavaScriptHelper {
    /**
     * Highlights a web element
     *
     * @param webdriver
     * @param element
     * @throws InterruptedException
     */
    public static void highLightWebElement(WebDriver webdriver, WebElement element) throws InterruptedException {
        JavascriptExecutor jsExecutor = (JavascriptExecutor) webdriver;
        String script = "arguments[0].setAttribute('style', arguments[1]);";
        String style = "color: green; border: 2px solid yellow;";

        jsExecutor.executeScript(script, element, style);
    }

    /**
     * Scrolls to an element
     *
     * @param webdriver
     * @param element
     */
    public static void scrollToElement(WebDriver webdriver, WebElement element) {
        JavascriptExecutor jsExecutor = (JavascriptExecutor) webdriver;
        String script = "arguments[0].scrollIntoView();";
        jsExecutor.executeScript(script, element);
    }
}
