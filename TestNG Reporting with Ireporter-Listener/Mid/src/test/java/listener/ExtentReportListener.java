package listener;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import org.openqa.selenium.support.PageFactory;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.IOException;

public class ExtentReportListener extends ExtentReport implements ITestListener {

//    ExtentReports extent;
//
//    ExtentTest test;
    public static String name;
    public static int count=0;

    public ExtentTest gettest(){
        return test;
    }
    @Override
    public void onTestStart(ITestResult iTestResult) {
        if(count!=0){
            test = extent.createTest(name);
            test.log(Status.INFO, "Staring test");
            count=0;
        }
        else{
            String name=iTestResult.getMethod().getMethodName();
            test = extent.createTest(name);
            test.log(Status.INFO, "Staring test");
        }
    }

    @Override
    public void onTestSuccess(ITestResult iTestResult) {
        try {
            T_Pass(test, iTestResult.getMethod().getMethodName());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void onTestFailure(ITestResult iTestResult) {
        try {
            T_Fail(test, iTestResult.getMethod().getMethodName());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void onTestSkipped(ITestResult iTestResult) {
        test.skip("test skipped");
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {

    }

    @Override
    public void onStart(ITestContext iTestContext) {
        Setup_Report("new2.html");
    }

    @Override
    public void onFinish(ITestContext iTestContext) {
//        extent.flush();
        flushing();
    }
}
