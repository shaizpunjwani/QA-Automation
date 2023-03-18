package PageObjects;

import Methods.methods;
import org.junit.Assert;

import java.awt.*;

public class CheckOut extends methods {

    public void Quantity(String path, String value){
        try{
            Sendvalues(value, FindXpath(path));
        } catch (Exception e){
            Assert.fail("Unable to send values in qty");
        }
    }

    public void Option(String path){
        try{
            ButtonClicking(FindXpath(path));
        } catch (Exception e){
            Assert.fail("unable to find option");
        }
    }

    public void Proceed(String path){
        try{
            ButtonClicking(FindXpath(path));
        } catch (Exception e){
            Assert.fail("Unable to find btn");
        }
    }

}
