package TestCases;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;

public class TeardownTest extends InstantiateTest{


    @AfterSuite
    public void Teardown(){
        extent.flush();
        home.quit();
    }
}
