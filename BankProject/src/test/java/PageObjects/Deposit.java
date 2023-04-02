package PageObjects;

import Implementation.Methods;
import Logger.Log;
import io.qameta.allure.Step;
import junit.framework.Assert;

public class Deposit extends Methods {

    Log log=new Log();
    public static int amount;

    @Step("Entering in to Deposit Section")
    public void GetintoDeposit(){
        try{
            ButtonClicking(FindXpath("/html/body/div/div/div[2]/div/div[3]/button[2]"));
            Assert.assertEquals("Amount to be Deposited :",FindXpath("/html/body/div/div/div[2]/div/div[4]/div/form/div/label").getText());
            log.info("Entered into deposit");
        } catch (Exception e){
            Assert.fail("Unbale to enter into deposit");
            log.error("Unbale to enter into deposit");
        }
    }

    @Step("Entering cash into account")
    public void DepositCash(String val){
        try{
            amount+=Integer.valueOf(val);
            Sendvalues(val, FindXpath("/html/body/div/div/div[2]/div/div[4]/div/form/div/input"));
            ButtonClicking(FindXpath("/html/body/div/div/div[2]/div/div[4]/div/form/button"));
            Assert.assertEquals(String.valueOf(amount), FindXpath("/html/body/div/div/div[2]/div/div[2]/strong[2]").getText());
            HomePage.transact++;
            log.info("Deposited");
        } catch (Exception e){
            Assert.fail("unable to deposit");
            log.error("unable to deposit");
        }
    }

    @Step("Entering negative amount")
    public void DepositNCash(String val){
        try{
            Sendvalues(val, FindXpath("/html/body/div/div/div[2]/div/div[4]/div/form/div/input"));
            Assert.assertEquals(String.valueOf(amount), FindXpath("/html/body/div/div/div[2]/div/div[2]/strong[2]").getText());
            log.info("Could not Deposit");
        } catch (Exception e){
            Assert.fail("deposited");
            log.error("deposited");
        }
    }

}
