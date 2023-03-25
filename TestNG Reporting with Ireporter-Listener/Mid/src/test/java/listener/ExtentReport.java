package listener;

import Utlis.PageFactory;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import java.io.IOException;

public class ExtentReport extends PageFactory {

    public static ExtentHtmlReporter htmlReporter;
    public static ExtentReports extent;

    public static ExtentTest test;

    public void Setup_Report(String rname){
        htmlReporter=new ExtentHtmlReporter(rname);
        extent = new ExtentReports();
        extent.attachReporter(htmlReporter);
        htmlReporter.config().setTheme(Theme.DARK);
        htmlReporter.config().setDocumentTitle("Automation Test Report");
        htmlReporter.config().setEncoding("uft-8");
        htmlReporter.config().setReportName("Automation Execution Report");
    }

    public void flushing(){
        extent.flush();
    }

    public void T_Pass(ExtentTest test, String name) throws IOException {
        test.pass("test passed");
        String screenshot2 = Utlis.PageFactory.getBase64Screenshot(name);
        test.log(Status.PASS,
                "<summary> <b> <font color=green> Test Passed: </b> "
                        + "</font>" + "</summary>",
                MediaEntityBuilder.createScreenCaptureFromBase64String(screenshot2).build());
    }

    public void T_Fail(ExtentTest test, String name) throws IOException {
        test.fail("test failed");
        String screenshot2 = Utlis.PageFactory.getBase64Screenshot(name);
        test.log(Status.FAIL,
                "<details>" + "<summary> <b> <font color=red> Cause of Failure: </b> " + "</font>" + "</summary>" +"<p>" + error + "</p>"+"</details>",
                MediaEntityBuilder.createScreenCaptureFromBase64String(screenshot2).build());
    }
}
