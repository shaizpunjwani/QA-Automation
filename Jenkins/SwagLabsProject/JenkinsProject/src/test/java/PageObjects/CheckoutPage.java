package PageObjects;

import Implementation.Methods;
import Loggers.Log;
import org.testng.Assert;
import org.testng.ITestResult;

import java.util.concurrent.TimeUnit;

public class CheckoutPage extends Methods {

    Log log=new Log();

    String error="Error";

    public void Setting_Info(String fname, String lname, String zip, int flag) throws InterruptedException {
        if (flag==1){
            Sendvalues(fname, FindXpath("//*[@id=\"first-name\"]"));
            Sendvalues(lname, FindXpath("//*[@id=\"last-name\"]"));
            Sendvalues(zip, FindXpath("//*[@id=\"postal-code\"]"));
            ButtonClicking(FindXpath("//*[@id=\"continue\"]"));
            CheckError();
            driver.navigate().refresh();
        }
        else{
            Sendvalues(fname, FindXpath("//*[@id=\"first-name\"]"));
            Sendvalues(lname, FindXpath("//*[@id=\"last-name\"]"));
            Sendvalues(zip, FindXpath("//*[@id=\"postal-code\"]"));
            ButtonClicking(FindXpath("//*[@id=\"continue\"]"));
            Assert.assertEquals("Checkout: Overview",FindXpath("//*[@id=\"header_container\"]/div[2]/span").getText());
        }
    }
    public void CheckError(){
        Assert.assertEquals(error, FindXpath("//*[@id=\"checkout_info_container\"]/div/form/div[1]/div[4]/h3").getText().substring(0,5));
    }
}