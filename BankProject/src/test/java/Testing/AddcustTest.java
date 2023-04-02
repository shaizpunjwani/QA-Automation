package Testing;

import PageObjects.AddCustPage;
import io.qameta.allure.*;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class AddcustTest {

    AddCustPage cp=new AddCustPage();

    @Test(priority = 1, description = "Adding customer", dataProvider = "getdata")
    @Description("Adding customer")
    @Epic("GAP06")
    @Feature("Adding customer")
    @Story("After landing on add customer we will add info")
    @Step("Adding customer info {fname}  {lname} {code}")
    @Severity(SeverityLevel.NORMAL)
    public void Adding(String fname, String lname, String code){
        cp.AddCustBtn();
        cp.Add(fname, lname, code);
    }

    @DataProvider
    public Object[][] getdata(){
        Object[][] data = new Object[1][3];
        data[0][0]= "Sp";
        data[0][1] = "punj";
        data[0][2] = "12345";
        return data;
    }
}
