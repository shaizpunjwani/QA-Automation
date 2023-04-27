package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OffersPage {

    public WebDriver driver;

    private By Search= By.xpath("//*[@id=\"search-field\"]");

    private By ProductName=By.xpath("//tr/child::td");

    public OffersPage(WebDriver driver){
        this.driver=driver;
    }

    public void SearchItem(String name){
        driver.findElement(Search).sendKeys(name);
    }

    public String GetProductName(){
        return driver.findElement(ProductName).getText();
    }

    public By GetSearchLoc(){
        return Search;
    }

    public By GetProductNameLoc(){
        return ProductName;
    }




}
