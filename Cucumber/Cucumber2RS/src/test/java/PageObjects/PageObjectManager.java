package PageObjects;

import org.openqa.selenium.WebDriver;

public class PageObjectManager {

    public LandingPage landing;
    public OffersPage offers;
    public CheckoutPage checkoutpage;

    WebDriver driver;
    public PageObjectManager(WebDriver driver){
        this.driver=driver;
    }

    public LandingPage GetLandingPage(){
        landing=new LandingPage(driver);
        return landing;
    }

    public OffersPage GetOffersPage(){
        offers=new OffersPage(driver);
        return offers;
    }

    public CheckoutPage GetCheckOutPage(){
        checkoutpage=new CheckoutPage(driver);
        return checkoutpage;
    }
}
