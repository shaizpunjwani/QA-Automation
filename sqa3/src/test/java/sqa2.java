import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class sqa2 {

    public static void main( String[] args ){
        System.setProperty("webdriver.chrome.driver", "C:/Users/USER/Desktop/sqa2/Driver/chromedriver.exe");
        WebDriver driver=new ChromeDriver();
        driver.navigate().to("https://www.google.com.pk");
        driver.quit();
    }
}
