package TestCases;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;

public class MenpageTest {

    Testing test=new Testing();

    @Test(priority = 1, description = "Second step")
    public void HomePages(){
        System.out.println("men page");
        test.landingMen();
        test.GotoCheckout();
    }
}
