package core;

public class Settings {

    private String browser;
    private String url;
    private long implicitTimeouts;
    private long clickWait;

    public long getClickWait() {
        return clickWait;
    }

    public void setClickWait(long clickWait) {
        this.clickWait = clickWait;
    }

    public String getBrowser() {
        return browser;
    }

    public void setBrowser(String browser) {
        this.browser = browser;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public long getImplicitTimeouts() {
        return implicitTimeouts;
    }

    public void setImplicitTimeouts(long implicitTimeouts) {
        this.implicitTimeouts = implicitTimeouts;
    }
}
