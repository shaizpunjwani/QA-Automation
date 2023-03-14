import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class signinwork {

    public static void main( String[] args ) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:/Users/USER/Desktop/sqa2/Driver/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.navigate().to("https://www.rahulshettyacademy.com/");
        List<WebElement> headingDiv= driver.findElements(By.cssSelector("div.login-btn"));
        WebElement span = headingDiv.get(1).findElement(By.tagName("a"));
        System.out.println("Href Value = "+span.getAttribute("href"));
        driver.navigate().to(span.getAttribute("href"));
        String titleElem = driver.findElement(By.xpath("//*[@class='container m-auto-xs col-4-l col-5-m col-10-xs p-h-6-l']/h3")).getAttribute("innerHTML");
        System.out.println(titleElem);

        driver.wait(10);
        driver.quit();
    }
}
