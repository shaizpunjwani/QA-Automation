import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Testing {
    WebDriver driver;

    @BeforeClass

    public void Launching() {
        Implementation imp=new Implementation();
        driver=imp.LaunchingBrowser();
    }
    @Test(priority = 1, description = "First_step")
    public void logins(){
        Implementation imp=new Implementation();
        driver=imp.SignUp(driver);
    }
    @Test(priority = 2, description = "Second_step")
    public void Fill() throws InterruptedException {
        Implementation imp= new Implementation();
        driver=imp.Form_Filling(driver);
    }
    @Test(priority = 3, description = "Third_step")
    public void Checking() throws InterruptedException {
        Implementation imp= new Implementation();
        imp.Final(driver);
    }
}
