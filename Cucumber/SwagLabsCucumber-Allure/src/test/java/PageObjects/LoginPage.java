package PageObjects;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class LoginPage {

    public WebDriver driver;
    private static final Logger log =  LogManager.getLogger(LoginPage.class);

    public LoginPage (WebDriver driver){
        this.driver=driver;
    }

    private By Username= By.xpath("//*[@id=\"user-name\"]");
    private By Password= By.xpath("//*[@id=\"password\"]");
    private By LoginBtn= By.xpath("//*[@id=\"login-button\"]");
    private By Loginpg=By.xpath("//*[@id=\"root\"]/div/div[1]");

    public void VerifyLoginPage(){
        log.info("checking loginpage");
        Assert.assertTrue(driver.findElement(Loginpg).getText().contains("Swag"));
    }

    public By GetLoginpgLoc(){
        return Loginpg;
    }

    public void EnterUsername(String username){
        try{
            driver.findElement(Username).sendKeys(username);
            log.info("entering uname");
        } catch (Exception e){
            Assert.fail("Unable to send username");
            log.error("unable to send user name");
        }
    }

    public void EnterPassword(String pwd){
        try{
            driver.findElement(Password).sendKeys(pwd);
            log.info("entered password");
        } catch (Exception e){
            Assert.fail("Unable to send password");
            log.error("unable to send password");
        }
    }

    public void ClickLoginButton(){
        try{
            driver.findElement(LoginBtn).click();
            log.info("clicked on login button");
        } catch (Exception e){
            Assert.fail("Unable to click login button");
            log.error("unable to click login button");
        }
    }
}
