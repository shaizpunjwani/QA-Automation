import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class titlework {

    public static void main( String[] args ) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:/Users/USER/Desktop/sqa2/Driver/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.navigate().to("https://www.rahulshettyacademy.com/");
        String titlename= driver.getTitle();
        System.out.println(titlename);
        driver.wait(10);
        driver.quit();
    }
}
