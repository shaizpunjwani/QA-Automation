package Testing;

import Logger.Log;
import PageObjects.Deposit;
import io.qameta.allure.*;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DepositpgTest {

    Log log=new Log();
    Deposit dep=new Deposit();

    @Test(priority = 1, description = "Depositing cash", dataProvider = "getdata")
    @Description("Depositing cash")
    @Epic("GAP03")
    @Feature("Depositing")
    @Story("After successful login customer should be able to deposit money")
    @Step("Depositing cash {val}")
    @Severity(SeverityLevel.NORMAL)
    public void EnterAmount(String val){
        dep.GetintoDeposit();
        dep.DepositCash(val);
    }

    @Test(priority = 1, description = "Depositing Negative value of cash")
    @Description("Depositing negative cash")
    @Epic("GAP03")
    @Feature("Depositing")
    @Story("After successful login customer should not be able to deposit negative money")
    @Step("Depositing negative cash")
    @Severity(SeverityLevel.NORMAL)
    public void EnterNAmount(){
        dep.DepositNCash("-1");
    }



    @DataProvider
    public Object[][] getdata(){
        Object[][] data = new Object[2][1];
        data[0][0]= "100";
        data[1][0] = "20";
        return data;
    }
}
