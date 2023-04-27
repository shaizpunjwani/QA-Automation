package StepDefinitions;

import PageObjects.LandingPage;
import Utils.TestContextSetup;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class LandingPageStepDefinition {
    TestContextSetup tcs;
    public LandingPage landing;


    public LandingPageStepDefinition(TestContextSetup tcs){
        this.tcs=tcs;
        landing=tcs.pageobjectmanager.GetLandingPage();
    }
    @Given("User is on GreenCart landing page")
    public void user_is_on_GreenCart_landing_page() throws IOException {
        System.out.println("User is on greekart page");
    }

    @When("User searches with short name called {string} and extracted actual name of product")
    public void user_searches_with_short_name_called_and_extracted_actual_name_of_product(String shortName) throws InterruptedException {
        landing.SearchItem(shortName);
        TimeUnit.SECONDS.sleep(2);
        tcs.product= landing.ExtractProductName(landing.GetProductName());
        System.out.println("product is "+tcs.product);
    }

    @When("Add the Quantity {string} of the Selected Product to the Cart")
    public void add_the_Quantity_of_the_Selected_Product_to_the_Cart(String qty) {
        landing.EnterQuantity(qty);
        landing.AddtoCartBtn();
    }

    @Then("user proceeds to checkout")
    public void user_proceeds_to_checkout() {
        landing.NavigatetoCart();
        tcs.generic.DriverW(landing.GetCheckoutpgLoc());
        landing.NavigatetoCheckOutPage();
    }
}
