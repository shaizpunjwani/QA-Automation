package Utlis;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Base64;
import java.util.Date;

public class PageFactory {

    public static WebDriver driver;
    public static String dest;

    public static String error;

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

        ChromeDriverService service = new ChromeDriverService.Builder().usingDriverExecutable(new File("C:\\Users\\USER\\Desktop\\TestNG Reporting\\Mid\\src\\test\\java\\chromedriver1.exe")).usingPort(9223).build();
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

    public void quit(){
        driver.close();
    }

    public static String getBase64Screenshot(String screenshotName) throws IOException {
        String screenshotFolder=System.getProperty("user.dir")+"/screenshot";
        String Base64StringofScreenshot = "";
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd__HH_mm_ss");
        LocalDateTime now = LocalDateTime.now();
        TakesScreenshot ts = (TakesScreenshot) driver;
        File source = ts.getScreenshotAs(OutputType.FILE);
        dest = screenshotFolder + "/" + dtf.format(now) + screenshotName + ".png";
        File destination = new File(dest);
        FileUtils.copyFile(source, destination);
        byte[] fileContent = FileUtils.readFileToByteArray(source);
        Base64StringofScreenshot = Base64.getEncoder().encodeToString(fileContent);
        return Base64StringofScreenshot;
    }

}
