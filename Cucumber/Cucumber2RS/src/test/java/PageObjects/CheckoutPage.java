package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class CheckoutPage {

    public WebDriver driver;

    private By Promo= By.xpath("//*[@id=\"root\"]/div/div/div/div/div/button");

    private By Placeorder= By.xpath("//*[@id=\"root\"]/div/div/div/div/button");

    private By Productname=By.xpath("//*[@id=\"productCartTables\"]/tbody/tr/td[2]/p");

    public CheckoutPage(WebDriver driver){
        this.driver=driver;
    }

    public void VerfifyProductName(String product){
        String prodname=driver.findElement(Productname).getText().split("-")[0].trim();
        Assert.assertEquals(product,prodname);
    }

    public By GetProductnameLoc(){
        return Productname;
    }


    public void VerifyPromoCode(){
        Boolean display=driver.findElement(Promo).isDisplayed();
        Assert.assertTrue(display);
    }
    public void VerifyPlaceOrder(){
        Boolean display=driver.findElement(Placeorder).isDisplayed();
        Assert.assertTrue(display);
    }
}
