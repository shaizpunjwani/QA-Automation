package PageObjects;

import Methods.methods;
import Waiting.Wait;
import org.testng.Assert;

import java.util.concurrent.TimeUnit;

public class Cart extends methods {
    Wait w=new Wait();
    public void View(String path){
        try{
            TimeUnit.SECONDS.sleep(3);
            ButtonClicking(FindXpath(path));
        } catch (Exception e){
            Assert.fail("unable to view");
        }
    }
}
