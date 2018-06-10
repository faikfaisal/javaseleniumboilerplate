package core.utilities;


import core.launcher.AppLauncher;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ElementCreator {
    private static Logger logger = Logger.getLogger(ElementCreator.class.getName());

    public static WebElement createElement(WebDriver driver, String elementDescription) throws UnSupportedLocator, InterruptedException {
        logger.info(String.format("trying to create element with locator %s", elementDescription));

        By locator = generateLocator(elementDescription);

        WebDriverWait wait = new WebDriverWait(driver, AppLauncher.getSettings().getClickWait());

        WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(locator));

        JavaScriptHelper.scrollToElement(driver, element);

        element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));

        JavaScriptHelper.highLightWebElement(driver, element);

        logger.info(String.format("Created element with locator %s", elementDescription));

        return element;
    }

    public static By generateLocator(String elementDescription) throws UnSupportedLocator {
        logger.info(String.format("Generating locator for %s", elementDescription));

        List<String> validLocatorsPatterns = new ArrayList<>(3);
        validLocatorsPatterns.add("^id=");
        validLocatorsPatterns.add("^css=");
        validLocatorsPatterns.add("^xpath=");

        String locator = "";

        for (String locatorPattern : validLocatorsPatterns) {
            Pattern pId = Pattern.compile(locatorPattern);
            Matcher matcher = pId.matcher(elementDescription);
            if (matcher.find()) {
                String identifier = locatorPattern.replace("^", "");
                locator = elementDescription.replace(identifier, "");
                if (identifier.equals("id=")) {
                    logger.info(String.format("Generated locator for %s", elementDescription));
                    return By.id(locator);
                } else {
                    if (identifier.equals("css=")) {
                        logger.info(String.format("Generated locator for %s", elementDescription));
                        return By.cssSelector(locator);
                    } else if (identifier.equals("xpath=")) {
                        logger.info(String.format("Generated locator for %s", elementDescription));
                        return By.xpath(locator);
                    }
                }
            }
        }

        logger.log(Level.SEVERE, String.format("Invalid locator %s", elementDescription));
        throw new UnSupportedLocator(elementDescription);
    }

}
