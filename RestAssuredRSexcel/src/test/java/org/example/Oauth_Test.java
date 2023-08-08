package org.example;

import io.restassured.path.json.JsonPath;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

import static io.restassured.RestAssured.*;

public class Oauth_Test {

    public static void main(String[] args) throws InterruptedException {

        //using selenium to get the url of auth_code
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\USER\\IdeaProjects\\Cucumber\\RestAssuredRS\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver=new ChromeDriver(options);
        driver.get("https://accounts.google.com/o/oauth2/v2/auth?scope=https://www.googleapis.com/auth/userinfo.email&auth_url=https://accounts.google.com/o/oauth2/v2/auth&client_id=692183103107-p0m7ent2hk7suguv4vq22hjcfhcr43pj.apps.googleusercontent.com&response_type=code&redirect_uri=https://rahulshettyacademy.com/getCourse.php");
        driver.findElement(By.xpath("//*[@id=\"identifierId\"]")).sendKeys("shaiz@students.uit.edu");
        driver.findElement(By.xpath("//*[@id=\"identifierId\"]")).sendKeys(Keys.ENTER);
        Thread.sleep(5000);
        driver.findElement(By.xpath("//*[@id=\"password\"]/div[1]/div/div[1]/input")).sendKeys("VIVOV11PRO");
        driver.findElement(By.xpath("//*[@id=\"password\"]/div[1]/div/div[1]/input")).sendKeys(Keys.ENTER);
        Thread.sleep(5000);
        String auth_url=driver.getCurrentUrl();
        System.out.println(auth_url);
        driver.quit();

        //extract code
        String partialurl=auth_url.split("code=")[1];
        String auth_code=partialurl.split("&scope")[0];

        System.out.println(auth_code);


        String accesstoken=given().urlEncodingEnabled(false).queryParams("code", auth_code).
                queryParams("client_id", "692183103107-p0m7ent2hk7suguv4vq22hjcfhcr43pj.apps.googleusercontent.com")
                .queryParams("client_secret", "erZOWM9g3UtwNRj340YYaK_W")
                .queryParams("redirect_uri", "https://rahulshettyacademy.com/getCourse.php")
                .queryParams("grant_type", "authorization_code")
                .when().log().all().post("https://www.googleapis.com/oauth2/v4/token").asString();

        JsonPath js=new JsonPath(accesstoken);
        String token=js.getString("access_token");


        String response=given().queryParam("access_token", token)
                .when().log().all().get("https://rahulshettyacademy.com/getCourse.php").asString();

        System.out.println(response);
    }
}
