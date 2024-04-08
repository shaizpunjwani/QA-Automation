package Listeners;
import Loggers.Log;
import Property.PropertyReader;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.IOException;

public class ExtentReportListener extends ExtentReport implements ITestListener {

    public static String name;
    public static int count=0;

    Log log=new Log();

    public static ExtentTest gettest(){
        return test;
    }

    @Override
    public void onTestStart(ITestResult iTestResult) {
        if(count!=0){
            test = extent.createTest(name);
            test.log(Status.INFO, "Retrying the test");
            test.log(Status.INFO, iTestResult.getMethod().getDescription());
            log.info(iTestResult.getMethod().getDescription());
            log.info("Retrying test");
            count=0;
        }
        else{
            String name=iTestResult.getMethod().getMethodName();
            test = extent.createTest(name);
            //login test
            if(((iTestResult.getParameters().length)==2) || (iTestResult.getParameters().length)==3){
                test.log(Status.INFO, "Staring test");
                log.info("Starting test");
                Object[] params=iTestResult.getParameters();
                test.log(Status.INFO, "Using username/Firstname: "+params[0]);
                log.info("Using username/Firstname: "+params[0]);
                test.log(Status.INFO, iTestResult.getMethod().getDescription());
                log.info(iTestResult.getMethod().getDescription());
                }
            else if (iTestResult.getMethod().getMethodName().equals("FLogin")){
                test.log(Status.INFO, "Staring test");
                log.info("Starting test");
                test.log(Status.INFO, "Using username/Firstname: "+PropertyReader.GetValue("uname"));
                log.info("Using username: "+PropertyReader.GetValue("uname"));
                test.log(Status.INFO, iTestResult.getMethod().getDescription());
                log.info(iTestResult.getMethod().getDescription());
            }
            else if(iTestResult.getMethod().getMethodName().equals("AddCorrectInfo")){
                test.log(Status.INFO, "Staring test");
                log.info("Starting test");
                test.log(Status.INFO, "Firstname: "+PropertyReader.GetValue("fname"));
                log.info("Using username: "+PropertyReader.GetValue("fname"));
                test.log(Status.INFO, iTestResult.getMethod().getDescription());
                log.info(iTestResult.getMethod().getDescription());
            }
            else{
                test.log(Status.INFO, "Staring test");
                log.info("Starting test");
                test.log(Status.INFO, iTestResult.getMethod().getDescription());
                log.info(iTestResult.getMethod().getDescription());
            }

        }
    }

    @Override
    public void onTestSuccess(ITestResult iTestResult) {
        try {
            T_Pass(test, iTestResult.getMethod().getMethodName());
            Log.info("This test is successful "+iTestResult.getMethod().getMethodName());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void onTestFailure(ITestResult iTestResult) {
        try {
            T_Fail(test, iTestResult.getMethod().getMethodName());
            log.error("Test failed");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    @Override
    public void onTestSkipped(ITestResult iTestResult) {
        test.skip("test skipped");
        log.info("Test skipped");
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {
        try {
            T_PassSuccess(test, iTestResult.getMethod().getMethodName());
            Log.info("This test is successful & within success % "+iTestResult.getMethod().getMethodName());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void onStart(ITestContext iTestContext) {
        //Log.info("Test cases started");
        try {
            PropertyReader.Load((System.getProperty("user.dir"))+"\\src\\test\\java\\Ressources\\config.properties");
            Setup_Report(PropertyReader.GetValue("report")+".html");
            log.info("report step up");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void onFinish(ITestContext iTestContext) {
//        extent.flush();
        //Log.info("Test case ended");
        flushing();
        log.info("End");
    }
}
