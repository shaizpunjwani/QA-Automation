package Testing;

import Logger.Log;
import Utils.PageFactory;
import org.testng.annotations.AfterSuite;

public class FlushingTest {

    Log log=new Log();

    @AfterSuite
    public void TearDown() throws InterruptedException {
        log.info("Closing driver");
        PageFactory.quit();
    }
}
