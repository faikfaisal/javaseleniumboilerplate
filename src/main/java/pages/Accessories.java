package pages;

import core.actions.GenericActions;
import core.actions.WebActions;


public class Accessories {

    private GenericActions actions;

    private static class Locators {
        private static final String ADD_TO_CHART = "css=div.input-button-buy";
    }

    public Accessories() {
        this.actions = new WebActions();
    }

    public void addToChartFirstItem() throws Exception {
        this.actions.click(Locators.ADD_TO_CHART);
    }
}
