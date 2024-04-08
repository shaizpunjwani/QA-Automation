package PageObjects;

import Implementation.Methods;
import Listeners.ExtentReportListener;
import Loggers.Log;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.testng.Assert;

public class FinishPage extends Methods {

    Log log=new Log();


    public void GetInfo(){
        String payinfo=FindXpath("//*[@id=\"checkout_summary_container\"]/div/div[2]/div[2]").getText();
        String shipinfo=FindXpath("//*[@id=\"checkout_summary_container\"]/div/div[2]/div[4]").getText();
        String priceinfo=FindXpath("//*[@id=\"checkout_summary_container\"]/div/div[2]/div[8]").getText();
        String pay="payment info"+payinfo;
        String ship="ship info"+shipinfo;
        String price="price info"+priceinfo;
        log.info(pay);
        log.info(ship);
        log.info(price);
        ExtentTest test=ExtentReportListener.gettest();
        test.log(Status.INFO, pay);
        test.log(Status.INFO, ship);
        test.log(Status.INFO, price);
        ButtonClicking(FindXpath("//*[@id=\"finish\"]"));
        Assert.assertEquals("Thank you for your order!",FindXpath("//*[@id=\"checkout_complete_container\"]/h2").getText());
    }
}
