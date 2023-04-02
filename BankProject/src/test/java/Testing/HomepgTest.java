package Testing;

import Logger.Log;
import PageObjects.HomePage;
import PageObjects.LoginPage;
import Property.PropertyReader;
import io.qameta.allure.*;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import Listeners.AllureListener;

import java.io.IOException;

@Listeners({AllureListener.class})
public class HomepgTest {

    PropertyReader pr=new PropertyReader();
    LoginPage lp=new LoginPage();
    Log log=new Log();

    HomePage hp=new HomePage();

    @BeforeClass
    public void Driver() throws IOException {
        pr.Load("C:\\Users\\USER\\IdeaProjects\\BankProject\\src\\test\\java\\Resources\\config.properties");
        hp.launchWebBrowser(pr.GetValue("url"));
        log.info("Web Browser launched");
    }


    @Test(priority = 1, description = "Verified Home page")
    @Description("verified Home page")
    @Epic("GAP01")
    @Feature("Verifying Homepg")
    @Story("After successful driver launched should be able to land on homepg")
    @Step("Verifying homepg")
    @Severity(SeverityLevel.NORMAL)
    public void LandedHomepg(){
        hp.LandedonHome();
    }

    @Test(priority = 2, description = "Navigated to customer login")
    @Description("Navigated to customer login")
    @Epic("GAP01")
    @Feature("Navigate to Login")
    @Story("After landing on homepg we should be able to navigate to login")
    @Step("Attempting to login")
    @Severity(SeverityLevel.NORMAL)
    public void NavigatedCustomerLogin(){
        hp.NavigateCustomerLogin();
    }

}
