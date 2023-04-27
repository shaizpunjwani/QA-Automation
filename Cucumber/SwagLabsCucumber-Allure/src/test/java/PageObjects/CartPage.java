package PageObjects;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class CartPage {

    WebDriver driver;
    private static final Logger log =  LogManager.getLogger(CartPage.class);


    public CartPage(WebDriver driver){
        this.driver=driver;
    }

    private By checkout= By.xpath("//*[@id=\"checkout\"]");

    public void GotoCheckout(){
        try{
            driver.findElement(checkout).click();
            log.info("goto checkout");
        }catch (Exception e){
            Assert.fail("Unable to goto checkout");
            log.error("Unable to goto checkout");
        }
    }

    public By GetCheckoutLoc(){
        return checkout;
    }
}
