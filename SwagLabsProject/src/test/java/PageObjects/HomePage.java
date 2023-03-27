package PageObjects;

import Implementation.Methods;
import Loggers.Log;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.List;

public class HomePage extends Methods {

    String sidebar="//*[@id=\"react-burger-menu-btn\"]";
    String logout="//*[@id=\"logout_sidebar_link\"]";

    String name="//*[@id=\"root\"]/div/div[1]";

    public static int nproduct=2;
    Log log=new Log();
    public void LogOut(){
        ButtonClicking(FindXpath(sidebar));
        ButtonClicking(FindXpath(logout));
        Assert.assertEquals("Swag Labs", FindXpath(name).getText());
    }

    public void SelectProducts(){
        List<WebElement> lst=driver.findElements(By.xpath("//button[text()=\"Add to cart\"]"));
        for(int i=0; i<nproduct; i++){
            log.info("added product");
            ButtonClicking(lst.get(i));
        }
        Assert.assertEquals(String.valueOf(nproduct), FindXpath("//*[@id=\"shopping_cart_container\"]/a/span").getText());
    }

    public void GotoCart(){
        log.info("Going to cart");
        ButtonClicking(FindXpath("//*[@id=\"shopping_cart_container\"]/a"));
    }
}
