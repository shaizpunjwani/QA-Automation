import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class contactwork {

    public static void main( String[] args ) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:/Users/USER/Desktop/sqa2/Driver/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.navigate().to("https://www.rahulshettyacademy.com/contact-us");
        driver.findElement(By.id("message")).sendKeys("It is a random test message");
        driver.findElement(By.tagName("button")).click();
        driver.wait(10);
        driver.quit();
    }
}
