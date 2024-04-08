package Testing;

import Loggers.Log;
import PageObjects.FinishPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FinishpgTest {

    Log log=new Log();
    FinishPage fp=new FinishPage();

    @Test(priority = 1, description = "Getting the total price, payment info")
    public void GetInfo(){
        try{
            Thread.sleep(2000);
            log.info("Validating info");
            fp.GetInfo();
        } catch (Exception e){
            Assert.fail("Could not validate retrieved info");
            log.error("Could not validate retrieved info");
        }
    }
}
