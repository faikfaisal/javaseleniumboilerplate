package core.launcher;

/**
 * Custom Exception thrown when chrome driver is not found
 */
public class ChromeDriverNotFoundInFramework extends Exception {
    public ChromeDriverNotFoundInFramework(String location) {
        super(String.format("Chromedriver not found in location %s", location));
    }
}
