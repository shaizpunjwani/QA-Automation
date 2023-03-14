import org.openqa.selenium.WebDriver;
public class Implementation {
    WebDriver driver;
    Methods meth = new Methods();

    public WebDriver LaunchingBrowser(WebDriver driver) {
        driver = meth.launchWebBrowser();
        return driver;
    }

    public WebDriver Products(WebDriver driver) throws InterruptedException {
        driver = meth.Men(driver);
        return driver;
    }

    public WebDriver Button(WebDriver driver, String path) {
        driver = meth.ClickButton(driver, path);
        return driver;
    }

    public WebDriver Inputsection(WebDriver driver, String path, String value, int choice) {
        if (choice==1){
            driver = meth.InputFields(driver, path, value);
        }
        else{
            driver = meth.DropDowns(driver, path, value);
        }
        return driver;
    }

    public WebDriver Asserts(WebDriver driver, String name, int a, String trueval){
        driver=meth.Text(driver, name, a, trueval);
        return driver;
    }
}
