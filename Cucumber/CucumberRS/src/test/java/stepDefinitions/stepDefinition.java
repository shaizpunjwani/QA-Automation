package stepDefinitions;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import java.util.List;

public class stepDefinition {


    @Given("validate browser")
    public void validate_browser() {
        System.out.println("-------Background1----------");
    }

    @When("browser is triggered")
    public void browser_is_triggered() {
        System.out.println("-------Background2----------");

    }

    @Then("check if browser is started")
    public void check_if_browser_is_started() {
        System.out.println("-------Background3----------");

    }

    @Given("^User is on NetBanking landing page$")
    public void user_is_on_netbanking_landing_page() throws Throwable {
        System.out.println("navigated to login url");
    }

    @When("^User login into application with username \"([^\"]*)\" and password \"([^\"]*)\"$")
    public void user_login_into_application_with_username_and_password(String uname, String pwd) throws Throwable {
        System.out.println("logged in successfully");
        System.out.println(uname);
        System.out.println(pwd);
    }

    @Then("^Home page is populated$")
    public void home_page_is_populated() throws Throwable {
        System.out.println("validated homepg");

    }

    @And("^Cards are displayed are \"([^\"]*)\"$")
    public void cards_are_displayed_are(String var) throws Throwable {
        System.out.println("validated cards");
        System.out.println(var);
    }

    @When("User sign up with following details")
    public void user_sign_up_with_following_details(io.cucumber.datatable.DataTable dataTable){
        List<List<String>> obj=  dataTable.asLists();
        //System.out.println(obj.get(0).get(0));
        for(int i=0; i<obj.size();i++){
            for(int j=0; j<obj.get(i).size(); j++){
                System.out.println(obj.get(i).get(j));
            }
        }
    }

    @When("User login into application with incorect username {string} and password {int}")
    public void user_login_into_application_with_incorect_username_and_password(String uname, Integer pwd) {
        System.out.println(uname);
        System.out.println(pwd);

    }
}
