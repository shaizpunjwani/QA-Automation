package Testing;

import Loggers.Log;
import PageObjects.HomePage;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class HomepgTest {

    HomePage hpg=new HomePage();
    Log log=new Log();

    @Test(priority = 1, description = "Adding products to cart")
    public void AddToCart(){
        try{
            log.info("Selecting products");
            hpg.SelectProducts();
        } catch (Exception e){
            Assert.fail("Failed to add products");
            log.error("Failed to add products");
        }
    }

    @Test(priority = 2, description = "Checking the Added products in Cart")
    public void CheckCart(){
        try{
            log.info("Checking products in cart");
            hpg.GotoCart();
        } catch (Exception e){
            Assert.fail("Failed to check products");
            log.error("Failed to check products");
        }
    }

}
