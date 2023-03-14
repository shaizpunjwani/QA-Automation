import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class task2 {
    public static void main( String[] args ) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:/Users/USER/Desktop/class 4/Assingment sqa week 3/Driver/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.navigate().to("https://rahulshettyacademy.com");
        driver.findElement(By.xpath("//a[@class='theme-btn register-btn']")).click();
        WebElement email = driver.findElement(By.id("email"));
        WebElement password = driver.findElement(By.id("password"));
        WebElement btn = driver.findElement(By.xpath("//input[@type='submit']"));
        email.sendKeys("shaiz@gmail.com");
        password.sendKeys("12345678");
        btn.click();


    }
}
