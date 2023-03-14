import org.openqa.selenium.By;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class practice {

    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:/Users/USER/Desktop/class 4/sqa1/Driver/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.navigate().to("https://rahulshettyacademy.com/AutomationPractice/");
        //driver.findElements(By.xpath("//select/option")).get(2).click();
        List<WebElement> headingDiv = driver.findElements(By.xpath("//select/option"));
        int size = headingDiv.size();
        for (int i = 0; i < size; i++) {
            driver.findElements(By.xpath("//select/option")).get(i).click();
        }
        List<WebElement> headingDiv1= driver.findElements(By.cssSelector("div.right-align"));
        for (int j=1; j<4; j++){
            driver.findElement(By.id("checkBoxOption"+j)).click();
        }


    }
}