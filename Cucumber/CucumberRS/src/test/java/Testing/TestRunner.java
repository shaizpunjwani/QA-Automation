package Testing;


import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
// to run multiple tags
//@CucumberOptions(
//        features = "src/test/java/Features",
//        glue = "stepDefinitions", tags = "@smokeTest or @sanityTest"
//)
// to run all tags except one of few use not
//@CucumberOptions(
//        features = "src/test/java/Features",
//        glue = "stepDefinitions", tags = "not @sanityTest"
//)

// to run the scenario which had 2 tags
//@CucumberOptions(
//        features = "src/test/java/Features",
//        glue = "stepDefinitions", tags = "@regTest and @unitTest"
//)
@CucumberOptions(
        features = "src/test/java/Features",
        glue = "stepDefinitions",
        tags = "@PortalTest",
        dryRun = false,
        monochrome = true,
        strict = true,
        plugin={"pretty", "html:target/cucumber.html", "json:target/cucumber.json", "junit:target/cukes.xml"}
)
public class TestRunner {
}
