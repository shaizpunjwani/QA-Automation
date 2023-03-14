import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.List;
import java.util.*;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;

public class shaiz2 {
    public static void main( String[] args ) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:/Users/USER/Desktop/class of testng/Assingment sqa week 5/Driver/chromedriver.exe");
        int flag=0;
        WebDriver driver = new ChromeDriver();
        //instantiating the chrome driver
        try {
            driver.navigate().to("https://ultimateqa.com/automation");
            flag=1;
            System.out.println("The Chrome Driver launched");

        } catch (Exception e) {
            System.out.println("Something went wrong.");

        }
        //only if the driver is instantiated
        if (flag==1){
            //navigating to the login automation
            try{
                driver.findElement(By.xpath("//a[text()=\"Login automation\"]")).click();
                System.out.println("Successfully landed on login automation");
            } catch (Exception e){
                System.out.println("Could found the desired xpath");
            }
            //instantiating javascriptexecutor
            JavascriptExecutor js = (JavascriptExecutor)driver;
            //here maximizing the window size so that the driver could locate checkbox and button
            driver.manage().window().maximize();
            try{
                driver.findElement(By.id("user[email]")).sendKeys("shaiz@gmail.com");
                driver.findElement(By.id("user[password]")).sendKeys("123456789");
                driver.findElement(By.xpath("//button[@type=\"submit\"]")).click();

                System.out.println("Successfully entered the values in input boxes");
            } catch (Exception e){
                System.out.println("tag given incorrect");
            }
            //WebElement landing=driver.findElement(By.xpath("//h2[@class=\"collections__heading\"]"));
            Thread.sleep(1000);
            String landing= driver.findElement(By.className("collections__heading")).getText();
            Assert.assertEquals("Products",landing);
            System.out.println(landing);

        }
    }
}
