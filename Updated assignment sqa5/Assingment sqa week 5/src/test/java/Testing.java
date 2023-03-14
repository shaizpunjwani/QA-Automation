import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Testing extends methods{

    @BeforeClass
    public void Launching() {
        launchWebBrowser();
    }

}
