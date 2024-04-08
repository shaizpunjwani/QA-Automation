package Testing;

import Listeners.ExtentReport;
import Loggers.Log;
import PageObjects.HomePage;
import PageObjects.LoginPage;
import Property.PropertyReader;
import Utlis.PageFactory;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.io.File;
import java.io.IOException;

import static Listeners.ExtentReport.extent;

public class LoginTest{

    PropertyReader pr = new PropertyReader();
    LoginPage lp=new LoginPage();
    HomePage home=new HomePage();

    Log log=new Log();

    @BeforeClass
    public void Driver() throws IOException {
        pr.Load((System.getProperty("user.dir"))+"\\src\\test\\java\\Ressources\\config.properties");
        lp.launchWebBrowser(pr.GetValue("url"));
        log.info("Web Browser launched");
    }
    @Test(priority = 1, description = "logging", dataProvider = "getdata")
    public void Login(String uname, String passw){
        try{
            log.info("Login atttempt");
            lp.Login(uname, passw);
            lp.LandedHomepg();
            log.info("Landed homepg");
            home.LogOut();
            log.info("Logout");
        } catch (Exception e){
            PageFactory.error=e.getMessage()+" ------Login failed------";
            Assert.fail("Login failed");
            log.error("Login fail");
        }
    }


    @Test(priority = 2, description = "final login")
    public void FLogin(){
        try{
            log.info("Login atttempt");
            lp.Login(pr.GetValue("uname"), pr.GetValue("passw"));
            log.info("Landed homepg");
            lp.LandedHomepg();
        } catch (Exception e){
            PageFactory.error=e.getMessage()+"Final Login failed";
            Assert.fail("Final Login failed");
            log.error("Login fail");
        }
    }
    @DataProvider
    public Object[][] getdata(){
        Object[][] data = new Object[3][2];
        data[0][0] = "problem_user";
        data[0][1] = "secret_sauce";
        data[1][0] = "locked_out_user";
        data[1][1] = "secret_sauce";
        data[2][0] = "performance_glitch_user";
        data[2][1] = "secret_sauce";
        return data;
    }
}
