package transactions;

import com.github.javafaker.Faker;
import core.launcher.AppLauncher;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import pages.*;

public class ProductTransactionTest {
    private AppLauncher launcher;
    private MainMenu mainMenu;
    private Accessories accessories;
    private Checkout checkout;
    private ContactDetails contactDetails;
    private TransactionResult result;

    @Before
    public void setUp() throws Exception {
        this.launcher = AppLauncher.getInstance();
        this.launcher.launch();

        this.mainMenu = new MainMenu();
        this.accessories = new Accessories();
        this.checkout = new Checkout();
        this.contactDetails = new ContactDetails();
        this.result = new TransactionResult();
    }

    @After
    public void tearDown() throws Exception {
        this.launcher.close();
    }

    @Test
    public void addProductToChartToCompleteTransactions() throws Exception {

        Faker faker = new Faker();
        final String firstName = faker.name().firstName();
        final String email = faker.internet().emailAddress();
        final String lastName = faker.name().lastName();
        final String billingAddress = faker.address().fullAddress();
        final String city = faker.address().city();
        final String country = "US";
        final String phone = faker.phoneNumber().phoneNumber();
        final String shippingState = faker.address().state();
        final String billingState = faker.address().state();
        final String productPrice = "$150.00";
        final String productName = "Magic Mouse";
        final int quantityAfterCheckout = 1;
        final int quantityBeforeCheckout = 0;

        Assert.assertTrue(this.mainMenu.ensureCartHeaderQuantity(quantityBeforeCheckout));

        checkoutFirstItem();

        Assert.assertTrue(this.mainMenu.ensureCartHeaderQuantity(quantityAfterCheckout));
        Assert.assertEquals(productName, this.checkout.getProductName(1));
        Assert.assertEquals(1, this.checkout.getProductQuantityOfFirstItem());

        this.checkout.clickContinue();

        completePurchase(
                firstName,
                email,
                lastName,
                billingAddress,
                city, country,
                phone,
                shippingState,
                billingState
        );


        boolean purchaseSuccess = this.result.ensureProductFoundInTable(
                productName,
                productPrice,
                "1",
                productPrice
        );

        Assert.assertTrue("Purchase was not successful, please the the transactions result", purchaseSuccess);

    }

    private void completePurchase(
            String firstName,
            String email,
            String lastName,
            String billingAddress,
            String city,
            String country,
            String phone,
            String shippingState,
            String billingState
    ) throws Exception {
        this.contactDetails.enterEmailAddress(email);
        this.contactDetails.enterFirstName(firstName);
        this.contactDetails.enterLastName(lastName);
        this.contactDetails.enterBillingAddress(billingAddress);
        this.contactDetails.enterCity(city);
        this.contactDetails.enterState(billingState);
        this.contactDetails.selectCountry(country);
        this.contactDetails.enterPhoneNumber(phone);
        this.contactDetails.enterShippingState(shippingState);
        this.contactDetails.clickPurchase();
    }

    private void checkoutFirstItem() throws Exception {
        this.mainMenu.clickAccessories();
        this.accessories.addToChartFirstItem();
        this.mainMenu.clickCheckout();
    }
}
