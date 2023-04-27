package StepDefinitions;

import PageObjects.LandingPage;
import PageObjects.LoginPage;
import Utils.TestContextSetup;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;

public class LoginPageStepDefinition {

    TestContextSetup tcs;
    public LoginPage login;
    public LandingPage landing;

    public LoginPageStepDefinition(TestContextSetup tcs){
        this.tcs=tcs;
        login=tcs.pageobjectmanager.GetLoginPage();
        landing=tcs.pageobjectmanager.GetLandingPage();
    }

    @Given("User is on Login Page")
    public void user_is_on_login_page() {
        tcs.generic.DriverW(login.GetLoginpgLoc());
        login.VerifyLoginPage();
    }
    @When("User enters username {string} and password {string}")
    public void user_enters_and(String uname, String password) {
        login.EnterUsername(uname);
        login.EnterPassword(password);
    }
    @When("User tries to Login")
    public void user_tries_to_login() {
        login.ClickLoginButton();
    }
    @Then("User is on the Landing page")
    public void user_is_on_the_landing_page() {
        tcs.generic.DriverW(landing.GetLandingPageLoc());
        landing.VerifyLandingPage();
    }


}
