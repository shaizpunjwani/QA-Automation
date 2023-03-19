package PageObjects;

import Methods.methods;
import org.testng.Assert;

public class Men extends methods {

    public void Landed(String path){
        try{
            String homepg= FindXpath(path).getText();
            Assert.assertEquals("Men", homepg);
        } catch (Exception e){
            Assert.fail("Unable to land on home page");
        }
    }

    public void Checkout(String path){
        try{
            ButtonClicking(FindXpath(path));
        } catch(Exception e){
            Assert.fail("Unable to land on checkout");
        }
    }

}
