import Files.PayLoad;
import JsonsPaths.Rawtojson;
import io.restassured.*;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class DynamicJson {

    String ID;
    String [] ids=new String[2];
    int counter=0;
    @Test(priority = 1, dataProvider = "getData")
    public void AddBook(String cname, String isbn, String aisle, String aname){
        System.out.println("adding book");
        RestAssured.baseURI="http://216.10.245.166";

        String response=given().log().all().header("Content-Type", "application/json")
                .body(PayLoad.AddBook(cname, isbn, aisle, aname)).when().post("/Library/Addbook.php")
                .then().log().all().assertThat().statusCode(200).extract().response().asString();

        ID= Rawtojson.rawtojson(response).getString("ID");
        ids[counter]=ID;
        counter++;
        System.out.println(ID);

    }

    @Test(priority = 2, alwaysRun = true)
    public void DeleteBook() {
        for (int i = 0; i < counter; i++){
            System.out.println("deleting book");
            RestAssured.baseURI = "http://216.10.245.166";

            String reponse2 = given().log().all().header("Content-Type", "application/json")
                    .body(PayLoad.DeleteBook(ids[i])).when().post("/Library/DeleteBook.php")
                    .then().log().all().assertThat().statusCode(200).extract().response().asString();

            Assert.assertEquals("book is successfully deleted", Rawtojson.rawtojson(reponse2).getString("msg"));

        }
    }

    @DataProvider
    public Object[][] getData(){
        return new Object[][] {{"Learn Appium Automation with Java", "bcd", "535", "John foe"}, {"Learn Appium Automation with Python", "shai", "5355", "John foe"}};
    }
}
