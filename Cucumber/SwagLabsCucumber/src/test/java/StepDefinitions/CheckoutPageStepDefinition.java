package StepDefinitions;

import PageObjects.CartPage;
import PageObjects.CheckoutPage;
import PageObjects.LandingPage;
import PageObjects.LoginPage;
import Utils.TestContextSetup;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.List;

public class CheckoutPageStepDefinition {

    TestContextSetup tcs;
    public CartPage cart;
    public CheckoutPage checkoutpage;
    public LandingPage landing;

    public CheckoutPageStepDefinition(TestContextSetup tcs){
        this.tcs=tcs;
        cart=tcs.pageobjectmanager.GetCartPage();
        checkoutpage=tcs.pageobjectmanager.GetCheckoutPage();
        landing=tcs.pageobjectmanager.GetLandingPage();
    }


    @Then("User proceeds to checkout")
    public void user_proceeds_to_checkout() {
        landing.GotoCart();
        tcs.generic.DriverW(cart.GetCheckoutLoc());
        cart.GotoCheckout();
    }

    @When("User enters its details firstname {string} lastname {string} and zip {string}")
    public void user_enters_its_details(String fname, String lname, String zip) {
        tcs.generic.DriverW(checkoutpage.GetFnameLoc());
        checkoutpage.EnterFirstname(fname);
        checkoutpage.EnterLastname(lname);
        checkoutpage.EnterZip(zip);
        checkoutpage.ContinueButton();
    }


}
