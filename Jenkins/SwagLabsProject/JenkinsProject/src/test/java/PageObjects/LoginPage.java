package PageObjects;

import Implementation.Methods;
import org.testng.Assert;

public class LoginPage extends Methods {

    String upath="//*[@id=\"user-name\"]";
    String ppath="//*[@id=\"password\"]";
    String btn="//*[@id=\"login-button\"]";

    String homepg="//*[@id=\"header_container\"]/div[1]/div[2]/div";

    public void Login(String uname, String password){

        Sendvalues(uname, FindXpath(upath));
        Sendvalues(password, FindXpath(ppath));
        ButtonClicking(FindXpath(btn));
    }

    public void LandedHomepg(){
        String name=FindXpath(homepg).getText();
        Assert.assertEquals("Swag Labs", name);
    }
}
