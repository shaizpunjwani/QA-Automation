import dev.failsafe.Execution;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Automation{

    public static void main( String[] args ){
        WebDriver driver;
        methods meth=new methods();
        driver=meth.launchWebBrowser();
        driver=meth.Login_Aut(driver);
        meth.Sign_Up(driver);

    }

}
