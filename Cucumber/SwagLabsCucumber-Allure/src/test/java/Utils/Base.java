package Utils;

import PageObjects.CartPage;
import Property.PropertyReader;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.io.File;
import java.io.IOException;

public class Base {

    public WebDriver driver;

    PropertyReader pr=new PropertyReader();
    private static final Logger log =  LogManager.getLogger(CartPage.class);


    public WebDriver WebDriverManager() throws IOException {
        pr.Load(System.getProperty("user.dir")+"//src//test//resources//global.properties");
        if(driver==null) {
            if(pr.GetValue("browser").equalsIgnoreCase("chrome")) {
                ChromeDriverService service = new ChromeDriverService.Builder().usingDriverExecutable(new File(System.getProperty("user.dir") + "//src//test//java//Driver//chromedriver.exe")).usingPort(9223).build();
                service.start();
                driver = new RemoteWebDriver(service.getUrl(), new ChromeOptions());
                log.info("setting driver");
            }
            driver.manage().window().maximize();
            driver.navigate().to(pr.GetValue("url"));
        }
        return driver;
    }
}
