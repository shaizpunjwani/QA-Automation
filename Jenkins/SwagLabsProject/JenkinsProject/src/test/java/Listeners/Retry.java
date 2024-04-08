package Listeners;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class Retry extends ExtentReportListener implements IRetryAnalyzer {

    int counter=0;
    int RetryLimit=1;

    @Override
    public boolean retry(ITestResult iTestResult) {
        if(!iTestResult.isSuccess()){
            if(counter<RetryLimit){
                counter++;
                ExtentReportListener.count=counter;
                ExtentReportListener.name=iTestResult.getMethod().getMethodName()+String.valueOf(counter);
                return true;
            }
        }
        return false;
    }

}
