import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;

public class Implementation {
    WebDriver driver;

    public WebDriver LaunchingBrowser() {
        methods meth = new methods();
        driver=meth.launchWebBrowser();
        return driver;
    }

    public WebDriver SignUp(WebDriver driver) {
        methods meth = new methods();
        driver=meth.Login_Aut(driver);
        meth.Sign_Up(driver);
        return driver;
    }

    public  WebDriver Form_Filling(WebDriver driver) throws InterruptedException {
        methods meth= new methods();
        driver=meth.Form_Fill(driver);
        return driver;
    }
    public  WebDriver Final(WebDriver driver) throws InterruptedException {
        methods meth= new methods();
        driver=meth.Products(driver);
        return driver;
    }
}
