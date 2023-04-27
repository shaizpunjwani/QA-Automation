package PageObjects;

import org.openqa.selenium.WebDriver;

public class PageObjectManager {

    public LoginPage login;
    public LandingPage landing;
    public CartPage cart;
    public CheckoutPage checkout;
    public FinalPage finalpg;

    WebDriver driver;
    public PageObjectManager(WebDriver driver){
        this.driver=driver;
    }

    public LoginPage GetLoginPage(){
        login=new LoginPage(driver);
        return login;
    }

    public LandingPage GetLandingPage(){
        landing=new LandingPage(driver);
        return landing;
    }

    public CartPage GetCartPage(){
        cart=new CartPage(driver);
        return cart;
    }
    public CheckoutPage GetCheckoutPage(){
        checkout=new CheckoutPage(driver);
        return checkout;
    }
    public FinalPage GetFinalPage(){
        finalpg=new FinalPage(driver);
        return finalpg;
    }

}
