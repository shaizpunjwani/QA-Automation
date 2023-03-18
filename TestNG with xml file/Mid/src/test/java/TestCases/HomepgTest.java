package TestCases;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;

public class HomepgTest {

    Testing test=new Testing();

    @BeforeClass
    public void loadDriver() throws IOException {
        System.out.println("Load driver");
        test.Driver();
    }

    @Test(priority = 1, description = "login", dataProvider = "getdata")
    public void Loginpg(String uname, String passw){
        test.login(uname, passw);
    }

    @DataProvider
    public Object[][] getdata(){
        Object[][] data = new Object[4][2];
        data[0][0] = " ";
        data[0][1] = " ";
        data[1][0] = "Admin";
        data[1][1] = " ";
        data[2][0] = " ";
        data[2][1] = "admin123";
        data[3][0] = "Admin";
        data[3][1] = "admin123";
        return data;
    }

//    @Test(priority = 1, description = "First step")
//    public void HomePages(){
//        System.out.println("Homepages");
//        test.LandingHomepg();
//        test.GotoMensection();
//    }
}
