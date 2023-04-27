package StepDefinitions;

import Utils.TestContextSetup;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Scenario;
import io.cucumber.java.Status;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;

public class Hooks {

    public TestContextSetup tcs;
    public static Boolean Rerun=false;
    public Hooks(TestContextSetup tcs){
        this.tcs=tcs;
    }

    @After
    public void after() throws IOException {
        tcs.base.WebDriverManager().quit();
    }

    //we used after step because failure ka chance tu step wise hoga

    @AfterStep
    public void CaptureScreenshot(Scenario scenario) throws IOException {
        WebDriver driver=tcs.base.WebDriverManager();
        if(scenario.isFailed()){
            File source=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
            byte[] filecontent= FileUtils.readFileToByteArray(source);
            scenario.attach(filecontent, "image/png", "<summary> <b> <font color=black> Scenario Failed: </font></b>"+"</summary>"+scenario.getName());
            scenario.log(Status.FAILED+"---STEP FAILED---");
            if(Rerun){
                scenario.log("<summary> <b> <font color=blue> Scenario Rerun: </font></b></summary>");
            }
        } else {
            if(Rerun){
                scenario.log("<summary> <b> <font color=blue> Scenario Rerun: </font></b></summary>");
            }
            scenario.log(Status.PASSED+"---STEP PASSED---");
        }
    }
}