package PageObjects;

import Implementation.Methods;
import Logger.Log;
import io.qameta.allure.Step;
import junit.framework.Assert;
import org.openqa.selenium.WebElement;


import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class TransactionPage extends Methods {

    Log log=new Log();
    List<WebElement> element=new ArrayList<WebElement>();


    @Step("Entering in to Transaction Section & verifying")
    public void CheckTransac(){
        try{
            ButtonClicking(FindXpath("/html/body/div/div/div[2]/div/div[3]/button[1]"));
            for(int i=0; i<HomePage.transact; i++){
                element.add(FindXpath("//*[@id='anchor'"+String.valueOf(i)+"]"));
            }
            if(element.size()==HomePage.transact){
                log.info("Transaction verified");
            }
            else{
                log.info("could not verify transaction");
            }
        } catch (Exception e){
            Assert.fail("could not transact");
            log.error("could not transact");
        }
    }

    @Step("Reseting transaction")
    public void Reset(){
        try{
            driver.navigate().refresh();
            ButtonClicking(FindXpath("/html/body/div/div/div[1]/button[2]"));
            if(FindXpath("//*[@id=\"anchor0\"]").isDisplayed()){
                log.info("could not reset");
            }
            else{
                log.info("reset done");
            }
        }catch (Exception e){
            Assert.fail("could not reset");
            log.error("could not reset");
        }
    }

    @Step("Clicking on logout")
    public void Logout(){
        try{
            ButtonClicking(FindXpath("/html/body/div/div/div[1]/button[2]"));
            Assert.assertEquals("Your Name :",FindXpath("/html/body/div/div/div[2]/div/form/div/label").getText());
            ButtonClicking(FindXpath("/html/body/div/div/div[1]/button[1]"));
            log.info("logout done");
        } catch (Exception e){
            Assert.fail("could not logout");
            log.error("could not logout");
        }
    }
}
