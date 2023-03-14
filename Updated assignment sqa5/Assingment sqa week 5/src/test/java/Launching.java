import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;

public class Launching {
    public WebDriver driver;
    public WebDriver launchWebBrowser(){
        WebDriverManager.chromedriver().setup();
        driver= new ChromeDriver();
        driver.navigate().to("https://ultimateqa.com/automation");
        driver.manage().window().maximize();
        System.out.println("Driver launched successfully");
        return driver;
    }

}
