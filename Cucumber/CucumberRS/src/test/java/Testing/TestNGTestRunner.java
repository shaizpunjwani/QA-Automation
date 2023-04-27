package Testing;


import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(features = "src/test/java/Features",
        glue = "stepDefinitions")
//to run cucumber with testng this method will be followed and AbstractTestNGCucumberTests extended
// the main difference between testngrunner and junit runner is that in testng we extends AbstractTestNGCucumberTests to run with cucumber whereas in junit we use @RunWith(Cucumber.class)

public class TestNGTestRunner extends AbstractTestNGCucumberTests {

}
