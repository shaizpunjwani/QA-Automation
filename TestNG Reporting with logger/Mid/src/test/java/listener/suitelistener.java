package listener;

import org.testng.ISuite;
import org.testng.ISuiteListener;

public class suitelistener implements ISuiteListener {

    @Override
    public void onStart(ISuite iSuite) {
        System.out.println("on start");
        System.out.println(iSuite.getName());
    }

    @Override
    public void onFinish(ISuite iSuite) {
        System.out.println("on finish");
        System.out.println(iSuite.getName());

    }
}
