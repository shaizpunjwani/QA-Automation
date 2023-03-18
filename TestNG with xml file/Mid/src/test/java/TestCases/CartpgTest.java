package TestCases;

import org.testng.annotations.Test;

public class CartpgTest {

    Testing test=new Testing();

    @Test(priority = 1, description = "Checking items", groups = "sanity")
    public void Viewing(){
        System.out.println("viewing");
        test.Viewitem();
    }
    @Test(priority = 2, description = "check")
    public void Done(){
        System.out.println("Exiting");
    }
}
