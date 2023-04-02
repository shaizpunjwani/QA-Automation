package Utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import java.io.File;
import java.io.IOException;

public class PageFactory {

    public static WebDriver driver;
    public static String dest;

    public static String error;

    public WebDriver launchWebBrowser(String appurl){

        ChromeDriverService service = new ChromeDriverService.Builder().usingDriverExecutable(new File("C:\\Users\\USER\\IdeaProjects\\BankProject\\src\\test\\java\\chromedriver1.exe")).usingPort(9223).build();
        try {
            service.start();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        driver = new RemoteWebDriver(service.getUrl(), new ChromeOptions());
        driver.manage().window().maximize();
        driver.navigate().to(appurl);
        return driver;
    }

    public WebDriver Getter(){
        return driver;
    }

    public static void quit(){
        driver.close();
    }

}
