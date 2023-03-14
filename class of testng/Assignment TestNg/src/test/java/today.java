import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


public class today {

    public WebDriver driver;

    @BeforeClass
    public WebDriver launchWebBrowser(){
        WebDriverManager.chromedriver().setup();
        driver= new ChromeDriver();
        driver.navigate().to("https://courses.ultimateqa.com/users/sign_in");
        driver.manage().window().maximize();
        return driver;
    }

    @Test(priority = 2, description = "First_step")
    public void Execution() {
        String titlename= driver.getTitle();
        //use Assert instead of If else
        System.out.println(titlename);

    }
    @Test(priority =1, description = "Second_step")
    public void CLosing() {
        driver.findElement(By.xpath("//*[@id=\"user[email]\"]")).sendKeys("Shaiz@gmail.com");
        driver.findElement(By.xpath("//*[@id=\"user[password]\"]")).sendKeys("12345678");

        //driver.quit();
        System.out.println("CLosing");
    }
    @Test(priority =3, description = "Third_step")
    public void Buttons() {
        driver.findElement(By.xpath("//*[@id=\"sign_in_5ea7d98c22\"]/div[5]/button\n")).click();

        //driver.quit();
        System.out.println("done");
    }



}



