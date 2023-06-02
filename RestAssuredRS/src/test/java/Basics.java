import Files.PayLoad;
import JsonsPaths.Rawtojson;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import org.testng.Assert;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class Basics {

    public static void main(String[] args) throws IOException {

        RestAssured.baseURI="https://rahulshettyacademy.com";
//        String response=given().log().all().queryParam("key", "qaclick123").header("Content-Type", "application/json")
//        .body(PayLoad.AddPlace()).when().post("/maps/api/place/add/json")
//        .then().log().all().assertThat().statusCode(200).body("scope", equalTo("APP"))
//        .header("Server", "Apache/2.4.41 (Ubuntu)")

        System.out.println("adding place");

        String response=given().queryParam("key", "qaclick123").header("Content-Type", "application/json")
        .body(new String(Files.readAllBytes(Paths.get("C:\\Users\\USER\\IdeaProjects\\Cucumber\\RestAssuredRS\\addplace.json")))).when().post("/maps/api/place/add/json")
        .then().assertThat().statusCode(200).body("scope", equalTo("APP"))
        .header("Server", "Apache/2.4.41 (Ubuntu)").extract().response().asString();

        System.out.println(response);
        String place_id= Rawtojson.rawtojson(response).getString("place_id");
        System.out.println(place_id);

        String address="32 trust summer, USA";

        System.out.println("updating place");

        given().log().all().queryParam("key", "qaclick123").header("Content-Type", "application/json")
                .body("{\n" +
                        "\"place_id\":\""+place_id+"\",\n" +
                        "\"address\":\""+address+"\",\n" +
                        "\"key\":\"qaclick123\"\n" +
                        "}\n")
                .when().put("/maps/api/place/update/json")
                .then().log().all().assertThat().statusCode(200).body("msg", equalTo("Address successfully updated"));


        System.out.println("Getting place");

        String GetResponse=given().log().all().queryParam("key", "qaclick123").queryParam("place_id", place_id)
                .when().get("/maps/api/place/get/json")
                .then().log().all().assertThat().statusCode(200).extract().response().asString();

        System.out.println(GetResponse);
        String addressjson= Rawtojson.rawtojson(GetResponse).getString("address");
        Assert.assertEquals(address, addressjson);

    }
}
