package pages;

import core.actions.GenericActions;
import core.actions.WebActions;

public class TransactionResult {
    private GenericActions actions;

    private static class Locators {
        private static String ADD_TO_CHART = "xpath=//td[text()='%s']";
    }

    public TransactionResult() {
        this.actions = new WebActions();
    }

    public boolean ensureProductFoundInTable(
            String productName,
            String productPrice,
            String quantity,
            String total
    ) {
        boolean isProductPresent = this.actions.ensureElementIsPresent(String.format(Locators.ADD_TO_CHART, productName));
        boolean isPricePresent = this.actions.ensureElementIsPresent(String.format(Locators.ADD_TO_CHART, productPrice));
        boolean isQuantityPresent = this.actions.ensureElementIsPresent(String.format(Locators.ADD_TO_CHART, quantity));
        boolean isTotalPricePresent = this.actions.ensureElementIsPresent(String.format(Locators.ADD_TO_CHART, total));

        return isProductPresent && isPricePresent && isQuantityPresent && isTotalPricePresent;
    }
}
