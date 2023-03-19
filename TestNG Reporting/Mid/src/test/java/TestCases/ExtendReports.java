package TestCases;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import java.io.IOException;

public class ExtendReports {

    public static void main( String[] args ) throws IOException {

        HomepgTest ht=new HomepgTest();
        MenpageTest mt=new MenpageTest();

        ExtentHtmlReporter htmlReporter=new ExtentHtmlReporter("extentReports.html");

        // create ExtentReports and attach reporter(s)
        ExtentReports extent = new ExtentReports();
        extent.attachReporter(htmlReporter);

        // creates a toggle for the given test, adds all log events under it
        ExtentTest test = extent.createTest("Home page test", "Checking whether we are in home pg and then navigating to mens section");

        test.log(Status.INFO, "Starting test case");
        ht.loadDriver();
        test.pass("driver loaded");
        //ht.HomePages();
        test.pass("navigated");

        ExtentTest test2 = extent.createTest("Men page test", "Click on product");

        test2.log(Status.INFO, "Starting test case2");
        mt.MenPage();
        test2.fail("failed to click");

        test.info("Completion");
        extent.flush();
    }
}
