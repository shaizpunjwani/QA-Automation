package PageObjects;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.List;

public class FinalPage {

    WebDriver driver;
    private static final Logger log =  LogManager.getLogger(FinalPage.class);


    public FinalPage(WebDriver driver){
        this.driver=driver;
    }

    //private By Product_Prices= By.xpath("div[class='inventory_item_price']");
    private By Product_Prices=By.className("inventory_item_price");
    private By shipping=By.xpath("//*[@id=\"checkout_summary_container\"]/div/div[2]/div[1]");
    private By Payment_info=By.xpath("//*[@id=\"checkout_summary_container\"]/div/div[2]/div[2]");
    private By Tax=By.xpath("//*[@id=\"checkout_summary_container\"]/div/div[2]/div[7]");
    private By Total_price=By.xpath("//*[@id=\"checkout_summary_container\"]/div/div[2]/div[8]");
    private By Finish=By.xpath("//*[@id=\"finish\"]");
    private By end=By.xpath("//*[@id=\"checkout_complete_container\"]/div");
    public double price=0.0;

    public void CheckPopulateditems(){
        try{
            Assert.assertTrue(driver.findElement(Product_Prices).isDisplayed());
            log.info("checked items are populated");
        } catch (Exception e){
            Assert.fail("The items have not been selected but still we could checkout");
            log.error("The items have not been selected but still we could checkout");
        }
    }
    public double RetrievePricesofSelecteditems(){
        List<WebElement> prices=driver.findElements(Product_Prices);
        for(int i=0; i< prices.size(); i++){
            String p=prices.get(i).getText().substring(1, prices.get(i).getText().length());
            price=price+Double.valueOf(p);
        }
        log.info("getting price of items");
        return price;
    }

    public double RetrieveTotal(){
        //String t=driver.findElement(Total_price).getText().split("$")[1].trim();
        String text=driver.findElement(Total_price).getText();
        String p=text.split(" ")[1];
        String t=p.substring(1, p.length());
        log.info("retrieved total price");
        return Double.valueOf(t);
    }
    public double RetrieveTax(){
        //String t=driver.findElement(Tax).getText().substring(1, driver.findElement(Tax).getText().length());
        String text=driver.findElement(Tax).getText();
        String p=text.split(" ")[1];
        String t=p.substring(1, p.length());
        log.info("retrieved total tax");
        return Double.valueOf(t);
    }

    public void VerifyTotalPrices(){
        double myitems=RetrievePricesofSelecteditems();
        double tax=RetrieveTax();
        double total=RetrieveTotal();
        log.info("retrieved total prices and verified");
        Assert.assertEquals(total,tax+myitems);
    }

    public void GetInformation(){
        String info=driver.findElement(Payment_info).getText();
        System.out.println(info);
        log.info("info retrieved");
    }

    public void FinishOrder(){
        driver.findElement(Finish).click();
        log.info("order ended");
    }
    public void ConfirmOrder(){
        String order=driver.findElement(end).getText();
        Assert.assertTrue(order.contains("Your order has been"));
        log.info("order confirmed");
    }

    public By GetFinalpgloc(){
        return shipping;
    }
    public By ConfirmLoc(){
        return end;
    }





}
