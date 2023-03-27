package Listeners;

import Loggers.Log;
import org.testng.ISuite;
import org.testng.ISuiteListener;

public class suitelistener implements ISuiteListener {

    Log log=new Log();

    @Override
    public void onStart(ISuite iSuite) {
        log.info("Starting suite"+ iSuite.getName());
    }

    @Override
    public void onFinish(ISuite iSuite) {
        log.info("Ending suite"+ iSuite.getName());
    }
}
