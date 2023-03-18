package TestCases;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;

public class CopyHomepg {

    Testing test=new Testing();

    @BeforeClass
    public void loadDriver() throws IOException {
        System.out.println("Load driver");
        test.Driver1();
    }

    @Test(priority = 1, description = "First step")
    public void HomePages(){
        System.out.println("Homepages");
        test.LandingHomepg();
        test.GotoMensection();
    }

}
