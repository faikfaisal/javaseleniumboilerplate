package core.launcher;

import org.openqa.selenium.WebDriver;

/**
 * This interface is used to get the driver from Factory
 */
public interface DriverFactory {
    WebDriver getWebDriver(String browser) throws ChromeDriverNotFoundInFramework, DriverNotFoundException;
}
