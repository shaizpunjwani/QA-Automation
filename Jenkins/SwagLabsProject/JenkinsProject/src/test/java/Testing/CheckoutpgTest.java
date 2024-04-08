package Testing;

import Loggers.Log;
import PageObjects.CheckoutPage;
import Property.PropertyReader;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class CheckoutpgTest {

    Log log=new Log();

    CheckoutPage cp=new CheckoutPage();

    @Test(priority = 1, description = "Filling out the incorrect details", dataProvider = "getdata")
    public void AddIncorrectInfo (String fname, String lname, String zip){
        try{
            log.info("Setting incorrect values");
            cp.Setting_Info(fname, lname, zip, 1);
        } catch (Exception e){
            Assert.fail("Unable to put values");
            log.error("Unable to put values");
        }
    }
    @Test(priority = 2, description = "Adding correct info")
    public void AddCorrectInfo(){
        try{
            log.info("Addning correct info");
            cp.Setting_Info(PropertyReader.GetValue("fname"), PropertyReader.GetValue("lname"),
                    PropertyReader.GetValue("zip"),0);
        } catch (Exception e){
            Assert.fail("Unable to put values");
            log.error("Unable to put values");
        }
    }

    @DataProvider
    public Object[][] getdata(){
        Object[][] data = new Object[3][3];
        data[0][0] = "";
        data[0][1] = "akber";
        data[0][2] = "12345";
        data[1][0] = "shaiz";
        data[1][1] = "";
        data[1][2] = "12345";
        data[2][0] = "shaiz";
        data[2][1] = "akber";
        data[2][2] = "";
        return data;
    }
}
