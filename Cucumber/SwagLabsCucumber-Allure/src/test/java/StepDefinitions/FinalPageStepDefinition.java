package StepDefinitions;

import PageObjects.CartPage;
import PageObjects.CheckoutPage;
import PageObjects.FinalPage;
import Utils.TestContextSetup;
import io.cucumber.java.en.Then;

import java.util.concurrent.TimeUnit;

public class FinalPageStepDefinition {

    TestContextSetup tcs;
    public FinalPage fpage;

    public FinalPageStepDefinition(TestContextSetup tcs){
        this.tcs=tcs;
        fpage=tcs.pageobjectmanager.GetFinalPage();
    }

    @Then("Page is populated with the details of items")
    public void page_is_populated_with_the_details_of_items() throws InterruptedException {
        tcs.generic.DriverW(fpage.GetFinalpgloc());
        fpage.CheckPopulateditems();
    }
    @Then("user verifies the items and prices")
    public void user_verifies_the_items_and_prices() {
        fpage.VerifyTotalPrices();
    }

    @Then("finishes order")
    public void finishes_order(){
        fpage.GetInformation();
        fpage.FinishOrder();
        tcs.generic.DriverW(fpage.ConfirmLoc());
        fpage.ConfirmOrder();
    }
}
