package Testing;

import Logger.Log;
import PageObjects.TransactionPage;
import io.qameta.allure.*;
import org.testng.annotations.Test;

public class TransacpgTest {

    Log log=new Log();

    TransactionPage tp=new TransactionPage();

    @Test(priority = 1, description = "Checking transaction")
    @Description("Checking transaction")
    @Epic("GAP05")
    @Feature("Transaction")
    @Story("After successful deposit and withdrawl transaction should be visible")
    @Step("Checking transaction")
    @Severity(SeverityLevel.MINOR)
    public void transact(){
        tp.CheckTransac();
        tp.Reset();
    }

    @Test(priority = 2, description = "Logout")
    @Description("Logout")
    @Epic("GAP05")
    @Feature("Logout")
    @Story("After successful transaction user should be able to Logout")
    @Step("Logout")
    @Severity(SeverityLevel.NORMAL)
    public void logout(){
        tp.Logout();
    }
}
