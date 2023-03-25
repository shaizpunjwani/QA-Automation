package Methods;

import Utlis.PageFactory;
import Waiting.Wait;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;


public class methods extends PageFactory {
    WebElement driver1;
    Wait wait=new Wait();
    public WebElement FindXpath(String path){

        wait.DriverW(driver, path);
        driver1= driver.findElement(By.xpath(path));
        return driver1;
    }

    public void Sendvalues(String value, WebElement driver){
        try{
            driver.clear();
            driver.sendKeys(value);
        } catch (Exception e){
            Assert.fail("unable to send values");
        }
    }

    public void ButtonClicking(WebElement driver){
        try{
            driver.click();
        } catch (Exception e) {
            Assert.fail("Unable to click");
        }
    }

    public void Scroll(){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,350)", "");
    }


}
