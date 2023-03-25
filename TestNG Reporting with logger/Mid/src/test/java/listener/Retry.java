package listener;

import com.relevantcodes.extentreports.ExtentTest;
import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

import java.io.IOException;

public class Retry extends ExtentReportListener implements IRetryAnalyzer {

    int counter=0;
    int RetryLimit=2;

    @Override
    public boolean retry(ITestResult iTestResult) {
        if(!iTestResult.isSuccess()){
            if(counter<RetryLimit){
                counter++;
                System.out.println(iTestResult.getMethod().getMethodName());
                ExtentReportListener.count=counter;
                ExtentReportListener.name=iTestResult.getMethod().getMethodName()+String.valueOf(counter);
                return true;
            }
        }
        return false;
    }

}
