import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.*;
import org.openqa.selenium.JavascriptExecutor;
import java.util.concurrent.TimeUnit;

public class shaiz1 {
    public static void main( String[] args ) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:/Users/USER/Desktop/class 4/Assingment sqa week 3/Driver/chromedriver.exe");
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

            //navigating to the sign-up page
            try{
                //extracting the parent tag of aside
                WebElement sin= driver.findElement(By.xpath("//aside[@class=\"sign-in__sign-up\"]"));
                //getting the child tag
                List<WebElement> child = sin.findElements(By.xpath("./child::*"));
                for(int i=0; i<child.size(); i++){
                    //getting the href link of the child tag because the a tag was not clickable
                    driver.navigate().to(child.get(i).getAttribute("href"));
                    System.out.println("Landed successfully on sign-up page");
                }

            } catch (Exception e){
                System.out.println("Could found the desired xpath");
            }
            //instantiating javascriptexecutor
            JavascriptExecutor js = (JavascriptExecutor)driver;
            //here maximizing the window size so that the driver could locate checkbox and button
            driver.manage().window().maximize();
            //scrolling the page by 600 pixels
            js.executeScript("window.scrollBy(0, 600)");
            try{
                //declaring the dictionary for the input boxes along with my values
                Hashtable<String, String> my_dict = new Hashtable<String, String>();
                my_dict.put("first_name", "shaiz");
                my_dict.put("last_name", "akber");
                my_dict.put("email", "shaiz_akb@gmail.com");
                my_dict.put("password", "123456789");

                for (String key : my_dict.keySet()) {
                    WebElement text= driver.findElement(By.xpath("//input[@id=\"user["+key+"]\"]"));
                    text.sendKeys(my_dict.get(key));
                }
                driver.findElement(By.xpath("//input[@type=\"checkbox\"]")).click();
                driver.findElement(By.xpath("//button[@type=\"submit\"]")).click();
                System.out.println("Successfully entered the values in input boxes");
            } catch (Exception e){
                System.out.println("tag given incorrect");
            }
            WebElement landing=driver.findElement(By.xpath("//h2[@class=\"collections__heading\"]"));
            if(landing.getText().equals("Products")){
                System.out.println("Successfully landed into the website");
            }













        }
    }
}
