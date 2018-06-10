package pages;

import core.actions.GenericActions;
import core.actions.WebActions;

public class MainMenu {

    private GenericActions actions;

    private static class Locators {
        private static final String PRODUCT_CATEGORY = "css=a[href*=product-category]";
        private static final String ACCESSORIES = "css=a[href*=accessories]";
        private static final String CHECKOUT = "css=a.cart_icon";
        private static final String CART_HEADER = "id=header_cart";
    }

    public MainMenu() {
        actions = new WebActions();
    }


    public void hoverOverProductCategory() throws Exception {
        this.actions.hoverOverElement(Locators.PRODUCT_CATEGORY);
    }

    public void clickAccessories() throws Exception {
        hoverOverProductCategory();
        this.actions.click(Locators.ACCESSORIES);
    }

    public void clickCheckout() throws Exception {
        this.actions.click(Locators.CHECKOUT);
    }

    public boolean ensureCartHeaderQuantity(int quantity) throws Exception {
        final String expectedMessage = String.format("%s item |\n" +
                "Cart\n" +
                "Checkout", quantity);
        return this.actions.ensureTextChanged(Locators.CART_HEADER, expectedMessage);
    }
}
