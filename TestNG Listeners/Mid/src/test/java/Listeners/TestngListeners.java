package Listeners;

import org.apache.commons.logging.Log;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestngListeners implements ITestListener {

    @Override
    public void onTestStart(ITestResult iTestResult) {
        System.out.println("Test Starting");
    }

    @Override
    public void onTestSuccess(ITestResult iTestResult) {
        System.out.println("Test case succeeded");
    }

    @Override
    public void onTestFailure(ITestResult iTestResult) {
        System.out.println("Test case failed");
    }

    @Override
    public void onTestSkipped(ITestResult iTestResult) {
        System.out.println("Test case skipped");
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {

    }

    @Override
    public void onStart(ITestContext iTestContext) {

    }

    @Override
    public void onFinish(ITestContext iTestContext) {
        System.out.println("All tests finished");
    }
}
