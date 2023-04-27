package StepDefinitions;

import PageObjects.LandingPage;
import PageObjects.LoginPage;
import Utils.TestContextSetup;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.util.TimeUtils;

import java.util.concurrent.TimeUnit;

public class LandingPageStepDefinition {

    TestContextSetup tcs;
    public LandingPage landing;
    public LoginPage login;

    public LandingPageStepDefinition(TestContextSetup tcs){
        this.tcs=tcs;
        landing=tcs.pageobjectmanager.GetLandingPage();
        login=tcs.pageobjectmanager.GetLoginPage();
    }

    @When("User tries to Logout from Landing page")
    public void user_tries_to_logout_from_landing_page() {
        tcs.generic.DriverW(landing.GetSideMenuLoc());
        landing.ClickSideMenu();
        tcs.generic.DriverW(landing.GetLogoutBtnLoc());
        landing.ClickLogoutButton();
    }

    @When("User selects items to the cart")
    public void user_selects_items_to_the_cart() throws InterruptedException {
        landing.AddItemstoCart();
    }
}
