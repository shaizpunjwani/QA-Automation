package PageObjects;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class CheckoutPage {

    WebDriver driver;
    private static final Logger log =  LogManager.getLogger(CheckoutPage.class);


    public CheckoutPage(WebDriver driver){
        this.driver=driver;
    }

    private By fname= By.xpath("//*[@id=\"first-name\"]");
    private By lname= By.xpath("//*[@id=\"last-name\"]");
    private By Zip= By.xpath("//*[@id=\"postal-code\"]");
    private By proceedbtn=By.xpath("//*[@id=\"continue\"]");

    public void EnterFirstname(String first){
        try{
            driver.findElement(fname).sendKeys(first);
            log.info("entered username");

        }catch (Exception e){
            Assert.fail("unable to send firstname");
            log.error("unable to send firstname");
        }
    }

    public void EnterLastname(String last){
        try{
            driver.findElement(lname).sendKeys(last);
            log.info("entered lastname");
        }catch (Exception e){
            Assert.fail("unable to send lastname");
            log.error("unable to send lastname");
        }
    }

    public void EnterZip(String zcode){
        try{
            driver.findElement(Zip).sendKeys(zcode);
            log.info("entered zipcode");
        }catch (Exception e){
            Assert.fail("unable to send zip code");
            log.error("unable to send zip code");
        }
    }

    public void ContinueButton(){
        try{
            driver.findElement(proceedbtn).click();
            log.info("clicked on continue button");
        }catch (Exception e){
            Assert.fail("Unable to proceed");
            log.error("Unable to proceed");
        }
    }

    public By GetFnameLoc(){
        return fname;
    }
}
