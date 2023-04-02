package Testing;

import PageObjects.HomePage;
import io.qameta.allure.*;
import org.testng.annotations.Test;

public class HomepgTest2 {

    HomePage hp=new HomePage();

    @Test(priority = 1, description = "Navigated to bank manager login")
    @Description("Navigated to bank manager login")
    @Epic("GAP01")
    @Feature("Navigate to Login")
    @Story("After landing on homepg we should be able to navigate to login")
    @Step("Attempting to login")
    @Severity(SeverityLevel.NORMAL)
    public void NavigatedbankmanagerLogin(){
        hp.NavigateBankManagerLogin();
    }
}
