package TestCases;

import PageObjects.Men;
import Utlis.PageFactory;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;

public class MenpageTest extends InstantiateTest {

    Men men = new Men();

    @Test(priority = 1, description = "Second step")
    public void MenPage() throws IOException {
        System.out.println("men page");
        ExtentTest test3 = extent.createTest("checking men page", "checking men page");
        test3.log(Status.INFO, "Starting test case of navigating to men");
        men.Landed("//*[@id=\"page-title-heading\"]/span");
        test3.pass("validated men pg");
    }

    @Test(priority = 2, description = "goto checkout")
    public void Checkout() throws IOException {
        System.out.println("checkout");
        ExtentTest test4 = extent.createTest("checkout test", "Navigating to checkout page");
        test4.log(Status.INFO, "Starting test case of navigating to men");
        men.Checkout("//*[@id=\"maincontent\"]/div[4]/div[1]/div[1]/div[3]/div/div/ol/li[2]/div/a/span/span/img");
        String screenshot2= PageFactory.getBase64Screenshot("ss2");
        test4.pass("Screenshot", MediaEntityBuilder.createScreenCaptureFromBase64String(screenshot2).build());
    }
}
