package Listeners;

import Logger.Log;
import Utils.PageFactory;
import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class AllureListener extends PageFactory implements ITestListener {

    Log log=new Log();

    private static String getTestmethodname(ITestResult iTestResult){
        return iTestResult.getMethod().getConstructorOrMethod().getName();
    }

    @Attachment
    public byte[] SaveFailedSS(){
        return ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
    }
    @Attachment(value = "{TestLog}", type = "text/plain")
    public static String SaveTextLog(String message){
        return message;
    }


    public void onTestStart(ITestResult iTestResult) {
        System.out.println("In "+iTestResult.getName());
        iTestResult.setAttribute("WebDriver", driver);
        log.info("----"+getTestmethodname(iTestResult)+"----");
    }

    public void onTestSuccess(ITestResult iTestResult) {
        log.info("Sucessfully "+iTestResult.getMethod().getDescription());
    }

    public void onTestFailure(ITestResult iTestResult) {
        System.out.println("I am on "+getTestmethodname(iTestResult)+"which failed");
        System.out.println("SS captured for testcase "+getTestmethodname(iTestResult));
        log.error("Failed "+iTestResult.getMethod().getDescription());
        SaveFailedSS();
        log.info("SS taken");
        SaveTextLog(getTestmethodname(iTestResult)+" failed and Screenshot taken");
        log.info("log maintained");
    }

    public void onTestSkipped(ITestResult iTestResult) {

    }

    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {

    }

    public void onStart(ITestContext iTestContext) {

    }

    public void onFinish(ITestContext iTestContext) {
        log.info("Test case ended");
    }
}
