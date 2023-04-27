package Utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Iterator;
import java.util.Set;

public class GenericUtils {

    public WebDriver driver;

    public GenericUtils(WebDriver driver){
        this.driver=driver;
    }

    public void SwitchtoChildWindow(){
        //handling child window
        Set<String> s1 = driver.getWindowHandles();
        Iterator<String> i1 = s1.iterator();
        String Parent = i1.next();
        String Child = i1.next();
        driver.switchTo().window(Child);
    }

    public Boolean CheckURL(String name){
        if(driver.getCurrentUrl().equalsIgnoreCase(name)){
            return true;
        }
        else{
            return false;
        }
    }

    public void DriverW(By locator) {
        WebDriverWait wait = new WebDriverWait(driver, 5);
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));

    }
}
