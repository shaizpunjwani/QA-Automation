package Utils;

import Loggers.Log;
import org.testng.Assert;

import java.util.List;

public class CheckStatus {

    Log log=new Log();
    public void Verify_Status(List<String> statuses){

        for (String status : statuses){
            if (status.equalsIgnoreCase("active") || status.equalsIgnoreCase("inactive")){
                System.out.println("");
                log.info("status verified");
            }
            else{
                Assert.fail("Status verification failed");
                log.error("Status verification failed");
            }
        }
    }
}
