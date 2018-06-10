package core.utilities;

public class UnSupportedLocator extends Exception {
    public UnSupportedLocator(String locator) {
        super(String.format("locator %s is not supported", locator));
    }
}
