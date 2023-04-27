package CucumberOptions;

import StepDefinitions.Hooks;
import io.cucumber.testng.CucumberOptions;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import org.testng.annotations.DataProvider;

@CucumberOptions(features = "@target/failed_scenarios.txt", glue = "StepDefinitions",
        monochrome = true, dryRun = false,
        plugin={"pretty", "html:target/report.html", "json:target/report.json",
                "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"}
)

public class FailedTestRunner extends AbstractTestNGCucumberTests {
    //to run scenarios parallely
    @Override
    @DataProvider(parallel = true)
    public Object[][] scenarios(){
        Hooks.Rerun=true;
        return super.scenarios();
    }

}

