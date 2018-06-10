package core.actions;

import core.launcher.AppLauncher;
import core.utilities.ElementCreator;
import core.utilities.UnSupportedLocator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.logging.Level;
import java.util.logging.Logger;

public class WebActions implements GenericActions {
    private WebDriver driver;
    private AppLauncher appLauncher;
    private Logger logger = Logger.getLogger(WebActions.class.getName());

    public WebActions() {
        this.appLauncher = AppLauncher.getInstance();
        this.driver = appLauncher.getDriver();
    }

    @Override
    public void click(String elementDescription) throws UnSupportedLocator, InterruptedException {
        logger.info(String.format("Clicking %s", elementDescription));
        WebElement element = ElementCreator.createElement(this.driver, elementDescription);
        WebDriverWait wait = new WebDriverWait(driver, AppLauncher.getSettings().getClickWait());
        element = wait.until(ExpectedConditions.elementToBeClickable(element));
        element.click();
        logger.info(String.format("Click complete %s", elementDescription));
    }

    @Override
    public void write(String elementDescription, String content) throws Exception {
        logger.info(String.format("Writing to locator %s, value=%s", elementDescription, content));
        WebElement element = ElementCreator.createElement(this.driver, elementDescription);
        element.sendKeys(content);
    }

    @Override
    public void hoverOverElement(String elementDescription) throws UnSupportedLocator, InterruptedException {
        logger.info(String.format("Hovering over %s", elementDescription));
        WebElement element = ElementCreator.createElement(this.driver, elementDescription);
        Actions actionBuilder = new Actions(this.driver);
        actionBuilder.moveToElement(element).perform();
        logger.info(String.format("Hover over completed %s", elementDescription));
    }

    @Override
    public void selectItemFromDropDown(String elementDescription, String itemValueToSelect) throws Exception {
        logger.info(String.format("Selecting item %s with locator %s", itemValueToSelect, elementDescription));
        WebElement element = ElementCreator.createElement(this.driver, elementDescription);
        WebElement selectElement = element.findElement(By.tagName("select"));
        Select select = new Select(selectElement);
        logger.info(String.format("Selecting item by visible text %s", itemValueToSelect));
        select.selectByValue(itemValueToSelect);
        logger.info(String.format("Selected item %s with locator %s", itemValueToSelect, elementDescription));
    }

    @Override
    public boolean ensureElementIsPresent(String elementDescription) {
        try {
            ElementCreator.createElement(this.driver, elementDescription);
            return true;
        } catch (Exception ex) {
            logger.log(Level.SEVERE, ex.getMessage());
            return false;
        }
    }

    @Override
    public boolean ensureTextChanged(String elementDescription, String requiredText) throws Exception {
        logger.info(String.format("Ensuring text %s is present in %s", requiredText, elementDescription));
        WebElement element = ElementCreator.createElement(this.driver, elementDescription);
        WebDriverWait wait = new WebDriverWait(driver, AppLauncher.getSettings().getClickWait());
        try {
            wait.until(ExpectedConditions.textToBePresentInElement(element, requiredText));
            logger.info(String.format("Ensured text %s is present in %s", requiredText, elementDescription));
            return true;
        } catch (Exception ex) {
            logger.log(Level.SEVERE, ex.getMessage());
            return false;
        }
    }

    @Override
    public String getText(String elementDescription) throws Exception {
        logger.info(String.format("Get text for %s", elementDescription));
        WebElement element = ElementCreator.createElement(this.driver, elementDescription);
        String text = element.getText();
        logger.info(String.format("Text returned for locator %s is %s", elementDescription, text));

        return text;
    }

    @Override
    public String getAttribute(String elementDescription, String attribute) throws Exception {
        logger.info(String.format("Get attribute for locator %s, and attribute is %s", elementDescription, attribute));
        WebElement element = ElementCreator.createElement(this.driver, elementDescription);
        String attr = element.getAttribute(attribute);
        logger.info(String.format("Got attribute for locator %s, attr is %s", elementDescription, attr));

        return attr;
    }
}
