package pages;

import core.actions.GenericActions;
import core.actions.WebActions;

public class ContactDetails {

    private GenericActions actions;

    private static class Locators {
        private static final String FIRST_NAME = "css=input[title=billingfirstname]";
        private static final String EMAIL = "css=input[title=billingemail]";
        private static final String LAST_NAME = "css=input[title=billinglastname]";
        private static final String BILLING_ADDRESS = "css=textarea[title=billingaddress]";
        private static final String COUNTRY_PARENT = "id=uniform-wpsc_checkout_form_7";
        private static final String CITY = "css=input[title=billingcity]";
        private static final String STATE = "css=input[title=billingstate]";
        private static final String PHONE = "css=input[title=billingphone]";
        private static final String SHIPPING_STATE = "id=wpsc_checkout_form_15";
        private static final String PURCHASE = "css=input.make_purchase";
    }

    public ContactDetails() {
        this.actions = new WebActions();
    }

    public void enterEmailAddress(String email) throws Exception {
        this.actions.write(Locators.EMAIL, email);

    }

    public void enterFirstName(String firstName) throws Exception {
        this.actions.write(Locators.FIRST_NAME, firstName);
    }

    public void enterLastName(String lastName) throws Exception {
        this.actions.write(Locators.LAST_NAME, lastName);
    }

    public void enterBillingAddress(String address) throws Exception {
        this.actions.write(Locators.BILLING_ADDRESS, address);
    }

    public void enterCity(String city) throws Exception {
        this.actions.write(Locators.CITY, city);
    }

    public void selectCountry(String country) throws Exception {
        this.actions.selectItemFromDropDown(Locators.COUNTRY_PARENT, country);
    }

    public void enterShippingState(String address) throws Exception {
        this.actions.write(Locators.SHIPPING_STATE, address);
    }

    public void enterPhoneNumber(String number) throws Exception {
        this.actions.write(Locators.PHONE, number);
    }

    public void enterState(String state) throws Exception {
        this.actions.write(Locators.STATE, state);
    }

    public void clickPurchase() throws Exception {
        this.actions.click(Locators.PURCHASE);
    }
}
