package Testing;

import Loggers.Log;
import PageObjects.CartPage;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class CartpgTest {

    Log log=new Log();
    CartPage cp=new CartPage();

    @Test(priority = 1, description = "Removing products from Cart")
    public void RemoveProduct(){
        try{
            log.info("Removing products");
            cp.Remove();
        } catch (Exception e){
            Assert.fail("Failed to remove products");
            log.error("Failed to remove products");
        }
    }

    @Test(priority = 2, description = "Going to Checkout Products")
    public void CheckOut(){
        try{
            log.info("Check out products");
            cp.GotoCheckout();
        } catch (Exception e){
            Assert.fail("Failed to checkout");
            log.error("Failed to checkout");
        }
    }
}
