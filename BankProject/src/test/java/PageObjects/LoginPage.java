package PageObjects;

import Implementation.Methods;
import Logger.Log;
import Property.PropertyReader;
import io.qameta.allure.Step;
import junit.framework.Assert;
import org.openqa.selenium.support.ui.Select;

public class LoginPage extends Methods {

    Log log=new Log();

    @Step("Selecting the name of login customer")
    public void SelectName(){
        try{
            Select usr = new Select(FindXpath("//*[@id=\"userSelect\"]"));
            usr.selectByValue(PropertyReader.GetValue("user"));
            Assert.assertEquals("Login", FindXpath("/html/body/div/div/div[2]/div/form/button").getText());
            log.info("Selected name");
        } catch (Exception e){
            Assert.fail("Unable to select name");
            log.error("unable to select name");
        }
    }

    @Step("Proceeding to MainPage")
    public void Proceed(){
        try{
            ButtonClicking(FindXpath("/html/body/div/div/div[2]/div/form/button"));
            String message=(FindXpath("/html/body/div/div/div[2]/div/div[1]/strong").getText()).substring(0,7);
            Assert.assertEquals("Welcome", message);
            log.info("Proceeded to mainpage");
        }catch (Exception e){
            Assert.fail("could not proceed");
            log.error("Could not proceed to mainpage");
        }
    }
}
