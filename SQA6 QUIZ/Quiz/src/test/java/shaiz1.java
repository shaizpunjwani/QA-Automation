import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class shaiz1 {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:/Users/USER/Desktop/SQA QUIZ/Quiz/Driver/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.navigate().to("https://magento.softwaretestingboard.com/");

        driver.findElement(By.xpath("(//nav/ul/li)[3]")).click();
        driver.findElement(By.xpath("//a[text()=\"Pants\"]")).click();
        driver.findElement(By.xpath("//li[@class=\"item product product-item\"][1]")).click();
        Thread.sleep(10000);
        driver.findElement(By.xpath("//div[text()=\"32\"]")).click();
        driver.findElement(By.xpath("//div[@class=\"swatch-option color\"][1]")).click();
        driver.findElement(By.xpath("//button[@title=\"Add to Cart\"]\n")).click();
        Thread.sleep(10000);
        driver.findElement(By.xpath("//a[@class=\"action showcart\"]")).click();
        Thread.sleep(10000);
        driver.findElement(By.xpath("//button[@id=\"top-cart-btn-checkout\"]\n")).click();
        Thread.sleep(10000);
        driver.findElement(By.xpath("//*[@id=\"customer-email\"][1]")).sendKeys("shaiz@gmail.com");
        Thread.sleep(10000);
        driver.findElement(By.xpath("//input[@name=\"firstname\"]")).sendKeys("shaiz");
        driver.findElement(By.xpath("//input[@name=\"lastname\"]")).sendKeys("akber");
        driver.findElement(By.xpath("//input[@name=\"company\"]")).sendKeys("uit");
        driver.findElement(By.xpath("//input[@name=\"street[0]\"]")).sendKeys("flat number 32");
        driver.findElement(By.xpath("//input[@name=\"city\"]")).sendKeys("karachi");
        driver.findElement(By.xpath("//input[@name=\"postcode\"]")).sendKeys("12345");
        driver.findElement(By.xpath("//input[@name=\"telephone\"]")).sendKeys("03452253543");
        Select drpCountry = new Select(driver.findElement(By.name("country_id")));
        drpCountry.selectByVisibleText("Pakistan");
        driver.findElement(By.xpath("//input[@name=\"region\"]")).sendKeys("Sindh");
        Thread.sleep(10000);
        //driver.findElement(By.className("button action continue primary")).click();
        driver.findElement(By.xpath("//span[text()=\"Next\"]")).click();
        Thread.sleep(10000);
        String payment=driver.findElement(By.xpath("//div/div/div/div/div/div/div/div/label/span")).getText();
        Assert.assertEquals("My billing and shipping address are the same", payment);
        driver.findElement(By.xpath("//span[text()=\"Place Order\"]")).click();
        Thread.sleep(5000);
        String purchase=driver.findElement(By.xpath("//span[@class=\"base\"]")).getText();
        Assert.assertEquals("Thank you for your purchase!", purchase);
        String order=driver.findElement(By.xpath("//div/p/span")).getText();
        System.out.println(order);





    }
}
