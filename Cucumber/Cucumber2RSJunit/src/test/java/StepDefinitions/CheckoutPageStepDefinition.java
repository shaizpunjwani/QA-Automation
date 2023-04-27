package StepDefinitions;

import PageObjects.CheckoutPage;
import PageObjects.LandingPage;
import Utils.TestContextSetup;
import io.cucumber.java.en.Then;

public class CheckoutPageStepDefinition {

    TestContextSetup tcs;

    public CheckoutPage checkout;


    public CheckoutPageStepDefinition(TestContextSetup tcs){
        this.tcs=tcs;
        checkout=tcs.pageobjectmanager.GetCheckOutPage();
    }

    @Then("validated the selected product")
    public void validated_the_selected_product() {
        tcs.generic.DriverW(checkout.GetProductnameLoc());
        checkout.VerfifyProductName(tcs.product);
    }

    @Then("verify the user has ability of enter promo code and place the order")
    public void verify_the_user_has_ability_of_enter_promo_code_and_place_the_order() {
        checkout.VerifyPromoCode();
        checkout.VerifyPlaceOrder();
    }

}
