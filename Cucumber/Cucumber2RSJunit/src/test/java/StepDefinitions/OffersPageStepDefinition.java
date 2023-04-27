package StepDefinitions;

import PageObjects.LandingPage;
import PageObjects.OffersPage;
import Utils.TestContextSetup;
import io.cucumber.java.en.Then;
import org.junit.Assert;

import java.util.concurrent.TimeUnit;

public class OffersPageStepDefinition {

    TestContextSetup tcs;
    public OffersPage offers;

    public String product2;

    public OffersPageStepDefinition(TestContextSetup tcs){
        this.tcs=tcs;
        offers=tcs.pageobjectmanager.GetOffersPage();
    }

    @Then("User searches for {string} shortname in Offers page to check if product exist")
    public void user_searches_for_shortname_in_Offers_page_to_check_if_product_exist(String shortName) throws InterruptedException {
        SwitchWindow();
        tcs.generic.DriverW(offers.GetSearchLoc());
        offers.SearchItem(shortName);
        TimeUnit.SECONDS.sleep(2);
        product2= offers.GetProductName();
    }

    public void SwitchWindow(){
        //checks whether already switched to offers page.
        if(!tcs.generic.CheckURL("\"https://rahulshettyacademy.com/seleniumPractise/#/offers\"")) {
            LandingPage landing = tcs.pageobjectmanager.GetLandingPage();
            landing.NavigatetoOffersPage();
            tcs.generic.SwitchtoChildWindow();
        }
    }

    @Then("compare the result from offers page and landing page")
    public void compare_the_result_from_offers_page_and_landing_page() {
        if(product2.equals(tcs.product)){
            System.out.println("Consistent");
        }
        else{
            Assert.fail("Not Consistent");
        }
    }

}
