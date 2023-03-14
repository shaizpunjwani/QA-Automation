import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.Hashtable;
import java.util.List;

public class methods {
    public WebDriver driver;
    public WebDriver launchWebBrowser(){
        WebDriverManager.chromedriver().setup();
        driver= new ChromeDriver();
        driver.navigate().to("https://ultimateqa.com/automation");
        driver.manage().window().maximize();
        System.out.println("Driver launched successfully");
        return driver;
    }

    public WebDriver Login_Aut(WebDriver driver) {
        driver.findElement(By.xpath("//a[text()=\"Login automation\"]")).click();
        return driver;

    }

    public WebDriver Sign_Up(WebDriver driver) {
        WebElement sin= driver.findElement(By.xpath("//aside[@class=\"sign-in__sign-up\"]"));
        //getting the child tag
        List<WebElement> child = sin.findElements(By.xpath("./child::*"));
        for(int i=0; i<child.size(); i++){
            //getting the href link of the child tag because the a tag was not clickable
            driver.navigate().to(child.get(i).getAttribute("href"));
        }
        return driver;
    }

    public WebDriver Form_Fill(WebDriver driver) throws InterruptedException {
        JavascriptExecutor js = (JavascriptExecutor)driver;
        driver.manage().window().maximize();
        js.executeScript("window.scrollBy(0, 600)");
        Hashtable<String, String> my_dict = new Hashtable<String, String>();
        my_dict.put("first_name", "shaiz");
        my_dict.put("last_name", "akber");
        my_dict.put("email", "shaiz_akber999999@gmail.com");
        my_dict.put("password", "123456789");

        for (String key : my_dict.keySet()) {
            WebElement text= driver.findElement(By.xpath("//input[@id=\"user["+key+"]\"]"));
            text.sendKeys(my_dict.get(key));
        }
        driver.findElement(By.xpath("//input[@type=\"checkbox\"]")).click();
        driver.findElement(By.xpath("//button[@type=\"submit\"]")).click();
        Thread.sleep(10000);
        return driver;
    }

    public WebDriver Products(WebDriver driver) throws InterruptedException {
        Thread.sleep(1000);
        String landing= driver.findElement(By.className("collections__heading")).getText();
        Assert.assertEquals("Products",landing);
        return driver;

    }
}
