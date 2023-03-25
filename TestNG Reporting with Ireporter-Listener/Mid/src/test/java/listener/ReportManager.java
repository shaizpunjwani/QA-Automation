package listener;

import org.testng.*;
import org.testng.xml.XmlSuite;

import java.util.Collection;
import java.util.List;
import java.util.Map;

public class ReportManager implements IReporter {

    @Override
    public void generateReport(List<XmlSuite> list, List<ISuite> list1, String s) {
        for(ISuite suite: list1){
            System.out.println("suit name: "+ suite.getName());
            Map<String, ISuiteResult> suiteResults= suite.getResults();

            for(ISuiteResult sr: suiteResults.values()){
                ITestContext tc = sr.getTestContext();

                System.out.println("Test Tag Name:"+tc.getName()+
                        "Test start time: " + tc.getStartDate() +
                        "Test end time: " + tc.getEndDate() +
                        "Test report output dir: " + tc.getOutputDirectory());

                Collection<ITestNGMethod> failedmethod=tc.getFailedTests().getAllMethods();
                Collection<ITestNGMethod> passmethod=tc.getPassedTests().getAllMethods();
                System.out.println("Total failed methods: "+ failedmethod.size() +" and those are: ");
                for(ITestNGMethod itm : failedmethod){
                    System.out.println("Method description: " + itm.getDescription() + " Name: " + itm.getMethodName());
                }

                System.out.println("Total passed methods: "+ passmethod.size() +" and those are: ");
                for(ITestNGMethod itm : passmethod){
                    System.out.println("Method description: " + itm.getDescription() + " Name: " + itm.getMethodName());
                }

                System.out.println("Passed tests for suite is :" + tc.getPassedTests().getAllResults().size());
                System.out.println("Failed tests for suite is :" + tc.getFailedTests().getAllResults().size());
                System.out.println("Skipped tests for suite is:" + tc.getSkippedTests().getAllResults().size());
            }
        }
        System.out.println("Path - " + s);
    }
}
