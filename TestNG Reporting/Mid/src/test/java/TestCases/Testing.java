package TestCases;

import Delay.DelayDriver;
import PageObjects.*;
import Property.PropertyReader;
import Utlis.PageFactory;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.*;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;

import static Utlis.PageFactory.driver;

public class Testing extends PropertyReader {

    PropertyReader pr = new PropertyReader();
    Home home = new Home();
    Men men = new Men();
    ExtentHtmlReporter htmlReporter;
    ExtentReports extent;

    @BeforeSuite
    public void setup_report(){
        htmlReporter=new ExtentHtmlReporter("newreport.html");
        extent = new ExtentReports();
        //extent.loadConfig(new File(System.getProperty("user.dir")+"\\extent-config.xml"));
        extent.attachReporter(htmlReporter);
    }
    @BeforeClass()
    public void Driver() throws IOException {
        pr.Load("C:\\Users\\USER\\Desktop\\TestNG Reporting\\Mid\\src\\test\\java\\Resources\\config.properties");
        home.launchWebBrowser(pr.GetValue("url"));
    }

    @Test(priority = 1, description = "Landing home page")
    public void LandingHomepg() {
        ExtentTest test = extent.createTest("Home page test", "Checking whether we are in home pg");
        test.log(Status.INFO, "Starting test case of homepage");
        home.Landed("//*[@id=\"maincontent\"]/div[3]/div/div[2]/div[1]/a/span/span[1]");
        test.pass("landed homepage");
    }

    @Test(priority = 2, description = "Clicking on Men")
    public void GotoMensection() throws Exception {
        ExtentTest test2 = extent.createTest("navigating men page test", "Navigating to men page");
        test2.log(Status.INFO, "Starting test case of navigating to men");
        home.NavigateMen("//*[@id=\"ui-id-5\"]");
        String screenshot2=PageFactory.getBase64Screenshot("ss");
        test2.pass("Screenshot", MediaEntityBuilder.createScreenCaptureFromBase64String(screenshot2).build());

    }

    @Test(priority = 3, description = "Landing on Men section")
    public void landingMen() throws IOException {
        ExtentTest test3 = extent.createTest("checking men page", "checking men page");
        test3.log(Status.INFO, "Starting test case of navigating to men");
        men.Landed("//*[@id=\"page-title-heading\"]/span");
        test3.pass("validated men pg");
    }

    @Test(priority = 4, description = "Clicking on Product")
    public void GotoCheckout() throws IOException {
        ExtentTest test4 = extent.createTest("checkout test", "Navigating to checkout page");
        test4.log(Status.INFO, "Starting test case of navigating to men");
        men.Checkout("//*[@id=\"maincontent\"]/div[4]/div[1]/div[1]/div[3]/div/div/ol/li[2]/div/a/span/span/img");
        String screenshot2=PageFactory.getBase64Screenshot("ss2");
        test4.pass("Screenshot", MediaEntityBuilder.createScreenCaptureFromBase64String(screenshot2).build());

    }
    @AfterClass
    public void Teardown(){
        extent.flush();
        home.quit();
    }
}
