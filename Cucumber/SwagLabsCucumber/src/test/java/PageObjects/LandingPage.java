package PageObjects;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.List;

public class LandingPage {

    WebDriver driver;
    private static final Logger log =  LogManager.getLogger(LandingPage.class);


    public LandingPage(WebDriver driver){
        this.driver=driver;
    }

    private By Landingpg= By.xpath("//*[@id=\"header_container\"]/div[1]/div[2]/div");
    private By SideMenu=By.xpath("//*[@id=\"react-burger-menu-btn\"]");
    private By LogoutBtn= By.xpath("//*[@id=\"logout_sidebar_link\"]");
    private By AddtoCart=By.xpath("button[class=\"btn btn_primary btn_small btn_inventory\"]");
    private By cart=By.xpath("//*[@id=\"shopping_cart_container\"]/a");

    public void VerifyLandingPage(){
        Assert.assertTrue(driver.findElement(Landingpg).getText().contains("Swag"));
        log.info("checking landing page");
    }

    public void ClickSideMenu(){
        try {
            driver.findElement(SideMenu).click();
            log.info("clicking side menu");
        }catch (Exception e){
            Assert.fail("Unable to click SideMenu");
            log.error("unable to click sidemenu");
        }
    }

    public void ClickLogoutButton(){
        try {
            driver.findElement(LogoutBtn).click();
            log.info("clicked on logout button");
        }catch (Exception e){
            Assert.fail("Unable to Logout");
            log.error("Unable to Logout");
        }
    }

    public void AddItemstoCart(){
        try{
//            List<WebElement> items= driver.findElements(AddtoCart);
//            System.out.println("got element");
//            System.out.println(items.size());
//            items.get(0).click();
//            items.get(1).click();
            driver.findElement(By.xpath("//*[@id=\"add-to-cart-sauce-labs-backpack\"]")).click();
            driver.findElement(By.xpath("//*[@id=\"add-to-cart-sauce-labs-bike-light\"]")).click();
            log.info("items added to cart");
        }catch (Exception e){
            Assert.fail("Unable to add items to cart");
            log.error("Unable to add items to cart");
        }
    }

    public void GotoCart(){
        try{
            driver.findElement(cart).click();
            log.info("goto cart");
        }catch (Exception e){
            Assert.fail("Unable to navigate to cart");
            log.error("Unable to navigate to cart");
        }
    }

    public By GetSideMenuLoc(){
        return SideMenu;
    }
    public By GetLogoutBtnLoc(){
        return LogoutBtn;
    }
    public By GetLandingPageLoc(){
        return Landingpg;
    }
}
