package pages;

import core.actions.GenericActions;
import core.actions.WebActions;


public class Checkout {

    private GenericActions actions;

    private static class Locators {
        private static String PRODUCT_NAME = "css=td.wpsc_product_name_%s";
        private static final String PRODUCT_QUANTITY = "css=input[name=quantity]";
        private static final String CONTINUE = "xpath=//span[text()='Continue']";
    }

    public Checkout() {
        this.actions = new WebActions();
    }

    public String getProductName(int nthProduct) throws Exception {
        final String productNameLocator = String.format(Locators.PRODUCT_NAME, nthProduct - 1);
        return this.actions.getText(productNameLocator);
    }

    public int getProductQuantityOfFirstItem() throws Exception {
        final String text = this.actions.getAttribute(Locators.PRODUCT_QUANTITY, "value");
        return new Integer(text);
    }

    public void clickContinue() throws Exception {
        this.actions.click(Locators.CONTINUE);
    }
}
