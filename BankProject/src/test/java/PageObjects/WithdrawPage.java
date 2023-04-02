package PageObjects;

import Implementation.Methods;
import Logger.Log;
import io.qameta.allure.Step;
import junit.framework.Assert;

public class WithdrawPage extends Methods {

    Log log=new Log();

    @Step("Entering in to Withdraw Section")
    public void GetintoWithdraw(){
        try{
            ButtonClicking(FindXpath("/html/body/div/div/div[2]/div/div[3]/button[3]"));
            Assert.assertEquals("Amount to be Withdrawn :",FindXpath("//label[text()=\"Amount to be Withdrawn :\"]").getText());
            log.info("Entered into withdraw page");
        } catch (Exception e){
            Assert.fail("Could not and into withdraw section");
            log.info("Could not and into withdraw section");
        }
    }

    @Step("Entering cash to withdraw")
    public void WithdrawCash(String val){
        try{
            Sendvalues(val, FindXpath("/html/body/div/div/div[2]/div/div[4]/div/form/div/input"));
            ButtonClicking(FindXpath("/html/body/div/div/div[2]/div/div[4]/div/form/button"));
            log.info("Entered the withdrawn amount");
            if(Integer.valueOf(val)>Deposit.amount){
                Assert.assertEquals("Transaction Failed. You can not withdraw amount more than the balance.",FindXpath("/html/body/div/div/div[2]/div/div[4]/div/span").getText());
                log.info("transaction failed");
            }
            else{
                int left=Deposit.amount-Integer.valueOf(val);
                Assert.assertEquals(String.valueOf(left),FindXpath("/html/body/div/div/div[2]/div/div[2]/strong[2]").getText());
                log.info("transaction proceeded");
                log.info("amount leftover "+String.valueOf(left));
                HomePage.transact++;
            }
        } catch (Exception e){
            Assert.fail("unable to withdraw");
            log.error("unable to withdraw");
        }
    }
}
