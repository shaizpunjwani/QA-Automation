package Testing;

import Logger.Log;
import PageObjects.WithdrawPage;
import io.qameta.allure.*;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class WithdrawpgTest {

    Log log=new Log();

    WithdrawPage with=new WithdrawPage();

    @Test(priority = 1, description = "Withdrawing cash", dataProvider = "getdata")
    @Description("Withdrawing cash")
    @Epic("GAP04")
    @Feature("Withdrawing")
    @Story("After successful login and depositing money withdraw should be possible")
    @Step("Withdrawing cash {val}")
    @Severity(SeverityLevel.NORMAL)
    public void Withdraw(String val){
        with.GetintoWithdraw();
        with.WithdrawCash(val);
    }




    @DataProvider
    public Object[][] getdata(){
        Object[][] data = new Object[2][1];
        data[0][0]= "200";
        data[1][0] = "20";
        return data;
    }

}
