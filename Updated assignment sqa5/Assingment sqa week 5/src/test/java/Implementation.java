import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;

public class Implementation extends methods {

    public Implementation(WebDriver driver) {
        this.driver = driver;
    }

    public WebDriver SignUp() {
        methods meth = new methods();
        driver = meth.Login_Aut(driver);
        meth.Sign_Up(driver);
        return driver;
    }

    public WebDriver Form_Filling() throws InterruptedException {
        methods meth = new methods();
        driver = meth.Form_Fill(driver);
        return driver;
    }

    public WebDriver Final() throws InterruptedException {
        methods meth = new methods();
        driver = meth.Products(driver);
        return driver;
    }
}
