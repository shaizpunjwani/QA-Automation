package TestCases;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class CheckpgTest {

    Testing test=new Testing();

    @Parameters("val")
    @Test(priority = 1, description = "Entering val", groups = "sanity")
    public void Qty(String num){
        System.out.println("qty");
        test.Checkout(num);
    }

    @Test(priority = 2, description = "proceed", groups = "sanity")
    public void Proceeding(){
        System.out.println("proceding");
        test.Proceed();
    }
}
