package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.junit.Assert;

public class LandingPage {

    public WebDriver driver;

    private By Search= By.xpath("//*[@id=\"root\"]/div/header/div/div[2]/form/input");
    private By ProductName= By.xpath("//*[@id=\"root\"]/div/div[1]/div/div/h4");

    private By Offerspage= By.xpath("//*[@id=\"root\"]/div/header/div/div[3]/a[2]");
    private By Cart= By.xpath("//*[@id=\"root\"]/div/header/div/div[3]/a[4]/img");
    private By CheckOutpage= By.xpath("//*[@id=\"root\"]/div/header/div/div[3]/div[2]/div[2]/button");
    private By AddtoCart= By.xpath("//*[@id=\"root\"]/div/div[1]/div/div/div[3]/button");


    public LandingPage(WebDriver driver){
        this.driver=driver;
    }

    public void SearchItem(String name){
        driver.findElement(Search).sendKeys(name);
    }

    public String GetProductName(){
        return driver.findElement(ProductName).getText();
    }

    public String ExtractProductName(String name){
        return name.split("-")[0].trim();
    }

    public void VerifyLandingPage(){
        Assert.assertTrue(driver.getCurrentUrl().contains("GreenKart"));
    }

    public void NavigatetoOffersPage(){
        driver.findElement(Offerspage).click();
    }

    public void NavigatetoCart(){
        driver.findElement(Cart).click();
    }
    public void NavigatetoCheckOutPage(){
        driver.findElement(CheckOutpage).click();
    }
    public void EnterQuantity(String number){
        WebElement quantityCheckbox = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[1]/div/div/div[2]/input"));
        quantityCheckbox.clear();
        quantityCheckbox.sendKeys(number);
    }
    public void AddtoCartBtn(){
        driver.findElement(AddtoCart).click();
    }
    public By GetCheckoutpgLoc(){
        return CheckOutpage;
    }




}
