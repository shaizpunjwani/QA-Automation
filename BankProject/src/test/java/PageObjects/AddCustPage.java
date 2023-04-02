package PageObjects;

import Implementation.Methods;
import Logger.Log;
import io.qameta.allure.Step;
import junit.framework.Assert;

public class AddCustPage extends Methods {

    Log log=new Log();

    @Step("click on add customer")
    public void AddCustBtn(){
        try{
            ButtonClicking(FindXpath("/html/body/div/div/div[2]/div/div[1]/button[1]"));
            Assert.assertEquals("First Name :",FindXpath("/html/body/div/div/div[2]/div/div[2]/div/div/form/div[1]/label").getText());
            log.info("getting into add customer");
        } catch (Exception e){
            Assert.fail("unable to click on add customer");
            log.error("unable to click on add customer");
        }
    }

    @Step("Filling info")
    public void Add(String fname, String lname, String post){
        try{
            Sendvalues(fname, FindXpath("/html/body/div/div/div[2]/div/div[2]/div/div/form/div[1]/input"));
            Sendvalues(lname, FindXpath("/html/body/div/div/div[2]/div/div[2]/div/div/form/div[2]/input"));
            Sendvalues(post, FindXpath("/html/body/div/div/div[2]/div/div[2]/div/div/form/div[3]/input"));
            ButtonClicking(FindXpath("/html/body/div/div/div[2]/div/div[2]/div/div/form/button"));
            driver.switchTo().alert().accept();
            log.info("sended data");
        } catch (Exception e){
            Assert.fail("could not send values");
            log.error("could not send values");
        }
    }
}
