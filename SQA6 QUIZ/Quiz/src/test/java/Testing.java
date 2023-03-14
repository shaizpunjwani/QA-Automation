import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Testing {
    WebDriver driver;
    Implementation imp=new Implementation();
    @BeforeClass
    public void Launching() {
        driver=imp.LaunchingBrowser(driver);
    }
    @Test(priority = 1, description = "Ordering the product")

    public void firstsetp() throws InterruptedException {
        driver=imp.Products(driver);
        driver=imp.Button(driver, "//button[@title=\"Add to Cart\"]\n");
        Thread.sleep(10000);
        driver=imp.Button(driver, "//a[@class=\"action showcart\"]");
        Thread.sleep(10000);
        driver=imp.Button(driver, "//button[@id=\"top-cart-btn-checkout\"]\n");
        Thread.sleep(10000);
    }

    @Test(priority = 2, description = "Filling the details")

    public void secondstep() throws InterruptedException {
        driver=imp.Inputsection(driver,"//*[@id=\"customer-email\"][1]","shaiz@gmail.com",1);
        Thread.sleep(10000);
        driver=imp.Inputsection(driver,"//input[@name=\"firstname\"]","shaiz",1);
        driver=imp.Inputsection(driver,"//input[@name=\"lastname\"]","akber",1);
        driver=imp.Inputsection(driver,"//input[@name=\"company\"]","uit",1);
        driver=imp.Inputsection(driver,"//input[@name=\"street[0]\"]","flat number 32",1);
        driver=imp.Inputsection(driver,"//input[@name=\"city\"]","karachi",1);
        driver=imp.Inputsection(driver,"//input[@name=\"postcode\"]","12345",1);
        driver=imp.Inputsection(driver,"//input[@name=\"telephone\"]","03452253543",1);
        driver=imp.Inputsection(driver,"country_id","Pakistan",2);
        driver=imp.Inputsection(driver,"//input[@name=\"region\"]","Sindh",1);
        Thread.sleep(10000);
        driver= imp.Button(driver, "//span[text()=\"Next\"]");
        Thread.sleep(10000);
    }

    @Test(priority = 3, description = "Confirming the order")
    public void thirdstep() throws InterruptedException {
        driver=imp.Asserts(driver,"//div/div/div/div/div/div/div/div/label/span",1,"My billing and shipping address are the same");
        driver=imp.Button(driver,"//span[text()=\"Place Order\"]");
        Thread.sleep(5000);
        driver=imp.Asserts(driver,"//span[@class=\"base\"]",1,"Thank you for your purchase!");
        driver=imp.Asserts(driver,"//div/p/span",2,"None");
    }
}
