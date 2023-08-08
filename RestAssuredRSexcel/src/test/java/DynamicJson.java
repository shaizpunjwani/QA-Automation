import Excel_Data.DataDriven;
import Files.PayLoad;
import JsonsPaths.Rawtojson;
import io.restassured.*;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import static io.restassured.RestAssured.given;

public class DynamicJson {

    String ID;
    String [] ids=new String[2];
    int counter=0;
    @Test(priority = 1, dataProvider = "getData")
    public void AddBook(String cname, String isbn, String aisle, String aname) throws IOException {

        DataDriven d=new DataDriven();
        ArrayList data=d.getdata("RestAdbook");

        HashMap<String, Object> jsonAsMap=new HashMap<>();
        jsonAsMap.put("name", data.get(1));
        jsonAsMap.put("isbn", data.get(2));
        jsonAsMap.put("aisle", data.get(3));
        jsonAsMap.put("author", data.get(4));

        System.out.println("adding book");
        RestAssured.baseURI="http://216.10.245.166";

        Response response=given().log().all().header("Content-Type", "application/json")
                .body(jsonAsMap).when().post("/Library/Addbook.php")
                .then().log().all().assertThat().statusCode(200).extract().response();

        JsonPath json=new JsonPath(response.asString());
        ID=json.getString("ID");
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
