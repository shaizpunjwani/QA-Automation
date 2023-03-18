package TestCases;

import Delay.DelayDriver;
import PageObjects.*;
import Property.PropertyReader;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;

public class Testing extends PropertyReader {

    PropertyReader pr= new PropertyReader();
    Home home=new Home();
    Men men=new Men();

    CheckOut co=new CheckOut();

    Cart cart=new Cart();

    @BeforeClass()
    public void Driver() throws IOException {
        pr.Load("C:\\Users\\USER\\Desktop\\TestNG with reporting\\Mid\\src\\test\\java\\Resources\\config.properties");
        home.launchWebBrowser(pr.GetValue("urln"));
    }
    public void Driver1() throws IOException {
        pr.Load("C:\\Users\\USER\\Desktop\\TestNG with reporting\\Mid\\src\\test\\java\\Resources\\config.properties");
        home.launchWebBrowser(pr.GetValue("url"));
    }

    @Test(priority = 1, description = "login")
    public void login(String uname, String password){
        home.Login(uname, password);
    }

    @Test(priority = 1, description = "Landing home page")
    public void LandingHomepg(){
        home.Landed("//*[@id=\"maincontent\"]/div[3]/div/div[2]/div[1]/a/span/span[1]");
    }

    @Test(priority = 2, description = "Clicking on Men")
    public void GotoMensection(){
        home.NavigateMen("//*[@id=\"ui-id-5\"]");
    }
    @Test(priority = 3, description = "Landing on Men section")
    public void landingMen(){
        men.Landed("//*[@id=\"page-title-heading\"]/span");
    }

    @Test(priority = 4, description = "Clicking on Product")
    public void GotoCheckout(){
        men.Checkout("//*[@id=\"maincontent\"]/div[4]/div[1]/div[1]/div[3]/div/div/ol/li[2]/div/a/span/span/img");
    }

    @Test(priority = 5, description = "chek out")
    public void Checkout(String val){
        co.Quantity("//*[@id=\"qty\"]", val);
    }

    @Test(priority = 6, description = "size")
    public void Proceed(){
        co.Option("//*[@id=\"option-label-size-143-item-166\"]");
        co.Option("//*[@id=\"option-label-color-93-item-49\"]");
        co.Proceed("//*[@id=\"product-addtocart-button\"]");
    }

    @Test(priority = 7, description = "items")
    public void Viewitem(){
        cart.View("/html/body/div[1]/header/div[2]/div[1]/a");
    }
}
