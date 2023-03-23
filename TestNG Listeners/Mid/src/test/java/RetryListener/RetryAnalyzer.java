package RetryListener;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalyzer implements IRetryAnalyzer {

    int counter=0;
    int RetryLimit=3;

    @Override
    public boolean retry(ITestResult iTestResult) {
        if(counter<RetryLimit){
            counter++;
            return true;
        }
        return false;
    }
}
