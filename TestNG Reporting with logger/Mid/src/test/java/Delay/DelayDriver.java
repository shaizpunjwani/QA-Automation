package Delay;

import Utlis.PageFactory;
import org.testng.Assert;

public class DelayDriver extends PageFactory {

    public void Delays(int number) throws InterruptedException {
        try{
            Thread.sleep(number);
        } catch(Exception e){
            Assert.fail("Unable to delay driver");
        }
    }


}
