package Testing;

import PageObjects.LoginPage;
import io.qameta.allure.*;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import Listeners.AllureListener;

@Listeners({AllureListener.class})
public class LoginpgTest {

    LoginPage lp=new LoginPage();

    @Test(priority = 1, description = "selecting name at login page")
    @Description("Selecting name of the login person")
    @Epic("GAP02")
    @Feature("Login")
    @Story("After landing on customer login we should be able to enter name")
    @Step("login with specific name")
    @Severity(SeverityLevel.NORMAL)
    public void Select(){
        lp.SelectName();
        lp.Proceed();
    }
}
