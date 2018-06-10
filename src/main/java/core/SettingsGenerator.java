package core;

import core.utilities.FileUtils;

import java.io.IOException;
import java.util.Map;

public class SettingsGenerator {
    private static final String URL = "URL";
    private static final String BROWSER = "BROWSER";
    private static final String SETTINGS_FILE = "settings.yml";

    public static Settings generate() throws IOException {
        Settings defaultSettings = generateDefaultSettings();

        Settings settings = new Settings();
        Map<String, String> env = System.getenv();
        settings.setUrl(env.getOrDefault(URL, defaultSettings.getUrl()));
        settings.setBrowser(env.getOrDefault(BROWSER, defaultSettings.getBrowser()));

        settings.setImplicitTimeouts(defaultSettings.getImplicitTimeouts());
        settings.setClickWait(defaultSettings.getClickWait());

        return settings;
    }

    public static Settings generateDefaultSettings() throws IOException {
        Settings defaultSettings = new FileUtils().readYmlFile(SETTINGS_FILE, Settings.class);
        return defaultSettings;
    }
}
