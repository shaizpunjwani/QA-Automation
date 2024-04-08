package PageObjects;

import Implementation.Methods;
import Loggers.Log;
import org.testng.Assert;

public class CartPage extends Methods {

    Log log=new Log();

    String check="Checkout: Your Information";


    public void Remove(){
        ButtonClicking(FindXpath("//*[@id=\"remove-sauce-labs-backpack\"]"));
        log.info("product removed");
        String value=FindXpath("//*[@id=\"shopping_cart_container\"]/a/span").getText();
        Assert.assertEquals(String.valueOf(HomePage.nproduct-1),value);
    }

    public void GotoCheckout(){
        ButtonClicking(FindXpath("//*[@id=\"checkout\"]"));
        log.info("Going to checkout");
        String value=FindXpath("//*[@id=\"header_container\"]/div[2]/span").getText();
        Assert.assertEquals(check,FindXpath("//*[@id=\"header_container\"]/div[2]/span").getText());
    }
}
