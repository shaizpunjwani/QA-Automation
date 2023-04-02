package PageObjects;

import Implementation.Methods;
import Logger.Log;
import io.qameta.allure.Step;
import junit.framework.Assert;

public class HomePage extends Methods {

    Log log=new Log();

    public static int transact=0;

    @Step("Checking whether landed on homepg or not")
    public void LandedonHome(){
        try{
            Assert.assertEquals("XYZ Bank",FindXpath("/html/body/div/div/div[1]/strong").getText());
            log.info("landed on home page");
        } catch (Exception e){
            Assert.fail("Unable to land on home page");
            log.error("Unable to land on home page");
        }
    }

    @Step("Navigating to customer login btn")
    public void NavigateCustomerLogin(){
        try{
            ButtonClicking(FindXpath("/html/body/div/div/div[2]/div/div[1]/div[1]/button"));
            log.info("Navigated to customer login");
        }catch (Exception e){
            Assert.fail("Unable to navigate to Customer login");
            log.error("unable to navigate to Customer login");
        }
    }

    @Step("Navigating to bank manager login btn")
    public void NavigateBankManagerLogin(){
        try{
            ButtonClicking(FindXpath("/html/body/div/div/div[2]/div/div[1]/div[2]/button"));
            log.info("Navigated to bank manager login");
        }catch (Exception e){
            Assert.fail("Unable to navigate to bank manager login");
            log.error("unable to navigate to Bank manager login");
        }
    }
}
