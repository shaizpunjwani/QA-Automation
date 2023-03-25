package listener;

import org.testng.IHookCallBack;
import org.testng.IHookable;
import org.testng.ITestResult;

public class HookListener implements IHookable {

    @Override
    public void run(IHookCallBack iHookCallBack, ITestResult iTestResult) {
        if(iTestResult.getMethod().getMethodName().equals("Proceed")){
            System.out.println("Skipping");
            iTestResult.setStatus(iTestResult.SKIP);
            iTestResult.setThrowable(new Throwable("Skipped test case: " +iTestResult.getMethod().getMethodName().equals("Proceed")));
        }
        else{
            iHookCallBack.runTestMethod(iTestResult);
        }

    }
}
