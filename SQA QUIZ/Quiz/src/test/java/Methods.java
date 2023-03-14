import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class Methods {
    public WebDriver driver;
    public WebDriver launchWebBrowser(){
        WebDriverManager.chromedriver().setup();
        driver= new ChromeDriver();
        driver.navigate().to("https://magento.softwaretestingboard.com/");
        //driver.manage().window().maximize();
        return driver;
    }

    public WebDriver Men(WebDriver driver) throws InterruptedException {
        driver.findElement(By.xpath("(//nav/ul/li)[3]")).click();
        driver.findElement(By.xpath("//a[text()=\"Pants\"]")).click();
        driver.findElement(By.xpath("//li[@class=\"item product product-item\"][1]")).click();
        Thread.sleep(10000);
        driver.findElement(By.xpath("//div[text()=\"32\"]")).click();
        driver.findElement(By.xpath("//div[@class=\"swatch-option color\"][1]")).click();
        return driver;
    }

    public WebDriver ClickButton(WebDriver driver, String xpath){
        driver.findElement(By.xpath(xpath)).click();
        return driver;

    }

    public WebDriver InputFields(WebDriver driver, String path, String value){
        driver.findElement(By.xpath(path)).sendKeys(value);
        return driver;
    }

    public WebDriver DropDowns(WebDriver driver, String tname, String value){
        Select drpCountry = new Select(driver.findElement(By.name(tname)));
        drpCountry.selectByVisibleText(value);
        return driver;
    }

    public WebDriver Text(WebDriver driver, String name, int a, String trueval){
        String s1=driver.findElement(By.xpath(name)).getText();
        if (a==1){
            Assert.assertEquals(trueval, s1);
        }
        else{
            System.out.println("Your order is: ");
            System.out.println(s1);
        }
        return driver;

    }
}
