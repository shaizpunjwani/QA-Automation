import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class task1 {
    public static void main( String[] args ) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:/Users/USER/Desktop/class 4/Assingment sqa week 3/Driver/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.navigate().to("https://rahulshettyacademy.com");
        WebElement e1= driver.findElement(By.xpath("//div[@class='text' and contains(text(),'Make')]"));
        List<WebElement> e2= driver.findElements(By.xpath("//h3"));
        //System.out.println(e2.size());
        WebElement e3= driver.findElement(By.xpath("//a[text()='Courses']"));
        List<WebElement> e4= driver.findElements(By.xpath("//a[@class='new-navbar-highlighter']"));
        WebElement e5= driver.findElement(By.xpath("//a[text()='Mentorship']"));
        WebElement e6= driver.findElement(By.xpath("//a[text()='Job Support']"));
        WebElement e7= driver.findElement(By.xpath("//a[text()='Practice']"));
        WebElement e8= driver.findElement(By.xpath("//a[@class='theme-btn register-btn']"));
        WebElement e9= driver.findElement(By.xpath("//a[@class='theme-btn']"));
        //a[text()='All-Access Membership-Complete Access to 25+ Courses (and counting!)']
        WebElement e10= driver.findElement(By.xpath("//a[text()='All-Access Membership-Complete Access to 25+ Courses (and counting!)']"));

        driver.wait(10);
        driver.quit();
    }

}
