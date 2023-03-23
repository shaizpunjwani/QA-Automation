package TestCases;

import PageObjects.Home;
import Property.PropertyReader;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import java.io.IOException;

public class InstantiateTest {
    public static ExtentHtmlReporter htmlReporter;
    public static ExtentReports extent;

    PropertyReader pr = new PropertyReader();
    Home home = new Home();

    @BeforeSuite
    public void setup_report() throws IOException {
        System.out.println("Setting report");
        htmlReporter=new ExtentHtmlReporter("newreport.html");
        extent = new ExtentReports();
        //extent.loadConfig(new File(System.getProperty("user.dir")+"\\extent-config.xml"));
        extent.attachReporter(htmlReporter);
        System.out.println("Load driver");
        pr.Load("C:\\Users\\USER\\Desktop\\TestNG Reporting\\Mid\\src\\test\\java\\Resources\\config.properties");
        home.launchWebBrowser(pr.GetValue("url"));
    }

//    @BeforeClass
//    public void loadDriver() throws IOException {
//        System.out.println("Load driver");
//        pr.Load("C:\\Users\\USER\\Desktop\\TestNG Reporting\\Mid\\src\\test\\java\\Resources\\config.properties");
//        home.launchWebBrowser(pr.GetValue("url"));
//    }
}
