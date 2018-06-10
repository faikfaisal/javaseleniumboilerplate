package core.launcher;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.net.URL;

public class WebDriverFactory implements DriverFactory {
    private final static String CHROME_DRIVER_PROPERTY = "webdriver.chrome.driver";
    private final static String CHROME_DRIVER_LOCATION = "drivers/chromedriver";

    private String generateChromeDriverPath() throws ChromeDriverNotFoundInFramework {
        ClassLoader classLoader = getClass().getClassLoader();
        URL url = classLoader.getResource(CHROME_DRIVER_LOCATION);
        if (url == null) throw new ChromeDriverNotFoundInFramework(CHROME_DRIVER_LOCATION);
        return url.getPath();
    }

    /**
     * getWebDriver is used to configure different Webdriver.
     *
     * @param browser desired browser type
     * @return WebDriver
     * @throws ChromeDriverNotFoundInFramework
     * @throws DriverNotFoundException
     */
    public WebDriver getWebDriver(String browser) throws ChromeDriverNotFoundInFramework, DriverNotFoundException {
        if (AutomationDriver.CHROME.equals(browser)) {
            System.setProperty(CHROME_DRIVER_PROPERTY, generateChromeDriverPath());
            ChromeOptions options = new ChromeOptions();
            return new ChromeDriver(options);
        } else if (AutomationDriver.FIRE_FOX.equals(browser)) {
            return new FirefoxDriver();
        } else {
            throw new DriverNotFoundException(browser);
        }
    }
}
