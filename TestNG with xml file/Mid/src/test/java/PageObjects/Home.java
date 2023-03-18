package PageObjects;

import Methods.methods;
import org.testng.Assert;

public class Home extends methods {

    public void Landed(String path){
        try{
            String homepg= FindXpath(path).getText();
            Assert.assertEquals("New Luma Yoga Collection", homepg);
        } catch (Exception e){
            Assert.fail("Unable to land on home page");
        }
    }

    public void NavigateMen(String path){
        try{
            ButtonClicking(FindXpath(path));
        } catch (Exception e){
            Assert.fail("Unable to locate Men");
        }
    }

    public void Login(String uname, String password){
        Sendvalues(uname, FindXpath("//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[1]/div/div[2]/input"));
        Sendvalues(password, FindXpath("//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[2]/div/div[2]/input"));
        ButtonClicking(FindXpath("//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[3]/button"));
    }
}
