package core.launcher;

import core.Settings;
import core.SettingsGenerator;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

/**
 * AppLauncher is used to launch and close client.
 * WebDriver can be accessed via this class at any time of the application lifecycle.
 */
public class AppLauncher {

    private static AppLauncher ourInstance = new AppLauncher();
    private DriverFactory driverFactory;
    private static Settings settings;

    private WebDriver driver;

    public static AppLauncher getInstance() {
        return ourInstance;
    }

    public static Settings getSettings() {
        return settings;
    }

    public WebDriver getDriver() {
        return this.driver;
    }

    private AppLauncher() {
        driverFactory = new WebDriverFactory();
    }

    public void launch() throws Exception {
        settings = SettingsGenerator.generate();
        this.driver = this.driverFactory.getWebDriver(settings.getBrowser());
        this.driver.manage().timeouts().implicitlyWait(settings.getImplicitTimeouts(), TimeUnit.SECONDS);
        this.driver.manage().window().fullscreen();
        driver.get(settings.getUrl());
    }

    public void close() throws Exception {
        this.driver.close();
        this.driver.quit();
    }
}
