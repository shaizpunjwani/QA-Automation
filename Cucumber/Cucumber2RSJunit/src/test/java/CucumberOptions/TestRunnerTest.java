package CucumberOptions;


import io.cucumber.junit.Cucumber;
import org.junit.runner.RunWith;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/java/Features", glue = "StepDefinitions",
                monochrome = true, dryRun = false, tags = "@Ordering or @Searching",
        plugin={"pretty", "html:target/report.html", "json:target/report.json",
                "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
                "rerun:target/failed_scenarios.txt"}
)

public class TestRunnerTest {

}

