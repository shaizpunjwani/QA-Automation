package TestCases;

import PageObjects.*;
import Property.PropertyReader;

import Utlis.PageFactory;
import junit.framework.Assert;
import listener.ExtentReportListener;
import org.openqa.selenium.devtools.v85.page.Page;
import org.testng.annotations.*;
import java.io.IOException;
public class Testing extends PropertyReader {

    PropertyReader pr = new PropertyReader();
    Home home = new Home();
    Men men = new Men();


    @BeforeClass()
    public void Driver() throws IOException {
        pr.Load("C:\\Users\\USER\\Desktop\\TestNG Reporting\\Mid\\src\\test\\java\\Resources\\config.properties");
        home.launchWebBrowser(pr.GetValue("url"));
    }

    @Test(priority = 1, description = "Landing home page")
    public void LandingHomepg() {
        home.Landed("//*[@id=\"maincontent\"]/div[3]/div/div[2]/div[1]/a/span/span[1]");
    }


    @Test(priority = 2, description = "Landing on Men section")
    public void landingMen() throws IOException {
        home.NavigateMen("//*[@id=\"ui-id-5\"]");
        men.Landed("//*[@id=\"page-title-heading\"]/span");
    }

    @Test(priority = 3, description = "Clicking on Product")
    public void Checkout() throws IOException {
        try{
            men.Checkout("//*[@id=\"maincontent\"]/div[4]/div[1]/div[1]/div[3]/div/div/ol/li[2]/div/a/span/span/img/rgr");
        } catch(Exception e){
            PageFactory.error=e.getMessage();
            Assert.assertTrue(false);
        }
    }
    @AfterClass
    public void Teardown(){
        home.quit();
    }
}
