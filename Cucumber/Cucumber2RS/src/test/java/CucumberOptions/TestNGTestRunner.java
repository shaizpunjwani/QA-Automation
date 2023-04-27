package CucumberOptions;

import io.cucumber.testng.CucumberOptions;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import org.testng.annotations.DataProvider;

@CucumberOptions(features = "src/test/java/Features", glue = "StepDefinitions",
                monochrome = true, dryRun = false, tags = "@Ordering or @Searching",
        plugin={"pretty", "html:target/report.html", "json:target/report.json",
                "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
                "rerun:target/failed_scenarios.txt"}
)

public class TestNGTestRunner extends AbstractTestNGCucumberTests {
    //to run scenarios parallely
    @Override
    @DataProvider(parallel = true)
    public Object[][] scenarios(){
        return super.scenarios();
    }

}

