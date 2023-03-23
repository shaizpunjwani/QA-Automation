package TestCases;

import Utlis.PageFactory;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;

public class HomepgTest extends InstantiateTest {

    @Test(priority = 1, description = "First step")
    public void HomePages() throws Exception {
        System.out.println("Homepages");
        ExtentTest test = extent.createTest("Home page test", "Checking whether we are in home pg");
        test.log(Status.INFO, "Starting test case of homepage");
        home.Landed("//*[@id=\"maincontent\"]/div[3]/div/div[2]/div[1]/a/span/span[1]");
        test.pass("landed homepage");
    }
    @Test(priority = 2, description = "goto men")
    public void Menpg() throws Exception {
        System.out.println("going men pg");
        ExtentTest test2 = extent.createTest("navigating men page test", "Navigating to men page");
        test2.log(Status.INFO, "Starting test case of navigating to men");
        home.NavigateMen("//*[@id=\"ui-id-5\"]");
        String screenshot2= PageFactory.getBase64Screenshot("ss");
        test2.pass("Screenshot", MediaEntityBuilder.createScreenCaptureFromBase64String(screenshot2).build());

    }
}
