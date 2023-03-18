package Utlis;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;

import java.io.File;
import java.io.IOException;

public class PageFactory {

    public static WebDriver driver;
    public WebDriver launchWebBrowser(String appurl) {

//        try {
//            WebDriverManager.chromedriver().setup();
//            ChromeOptions opt = new ChromeOptions();
//            driver = new ChromeDriver();
//            driver.navigate().to(appurl);
//            driver.manage().window().maximize();
//        } catch (Exception e) {
//            Assert.fail("Error in loading the chrome driver");
//        }
//        return driver;

        ChromeDriverService service = new ChromeDriverService.Builder().usingDriverExecutable(new File("C:\\Users\\USER\\Desktop\\TestNG with reporting\\Mid\\src\\test\\java\\chromedriver1.exe")).usingPort(9223).build();
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

}
