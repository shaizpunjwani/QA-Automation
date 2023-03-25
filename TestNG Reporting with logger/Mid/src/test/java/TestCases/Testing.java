package TestCases;

import Logs.Log;
import PageObjects.*;
import Property.PropertyReader;

import Utlis.PageFactory;
import junit.framework.Assert;
import listener.ExtentReportListener;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.devtools.v85.page.Page;
import org.testng.annotations.*;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;


public class Testing extends PropertyReader {

    PropertyReader pr = new PropertyReader();
    Home home = new Home();
    Men men = new Men();
    Checkout co=new Checkout();


    @BeforeClass()
    public void Driver() throws IOException {
        pr.Load("C:\\Users\\USER\\Desktop\\TestNG Reporting with logger\\Mid\\src\\test\\java\\Resources\\config.properties");
        home.launchWebBrowser(pr.GetValue("url"));
    }

//    @AfterMethod
//    public void afterMethod(Method method) {
//        Test test = method.getAnnotation(Test.class);
//        System.out.println("Test name is " + test.testName());
//        System.out.println("Test description is " + test.description());
//    }

    @Test(priority = 1, description = "Landing home page")
    public void LandingHomepg() {
        home.Landed("//*[@id=\"maincontent\"]/div[3]/div/div[2]/div[1]/a/span/span[1]");
    }

    @Test(priority = 2, description = "Landing on Men section")
    public void landingMen() throws IOException, InterruptedException {
        //TimeUnit.SECONDS.sleep(7);
        home.NavigateMen("//*[@id=\"ui-id-5\"]");
        men.Landed("//*[@id=\"page-title-heading\"]/span");

    }

    @Test(priority = 3, description = "Clicking on Product")
    public void Checkout() throws IOException {
        try{
            men.Checkout("//*[@id=\"maincontent\"]/div[4]/div[1]/div[1]/div[3]/div/div/ol/li[2]/div/a/span/span/img");
        } catch(Exception e){
            PageFactory.error=e.getMessage();
        }
    }

    @Test(priority = 4, description = "filling out details")
    public void Proceed(){
        try{
            co.Quantity("//*[@id=\"qty\"]", "1");
            co.Option("//*[@id=\"option-label-size-143-item-166\"]");
            co.Option("//*[@id=\"option-label-color-93-item-49\"]");
            co.Proceed("//*[@id=\"product-addtocart-button\"]");

        } catch (Exception e) {
            PageFactory.error=e.getMessage();
        }
    }
    @AfterClass
    public void Teardown(){
        home.quit();
    }
}
