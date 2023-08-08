package org.example;

import io.restassured.RestAssured;
import io.restassured.response.Response;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import static io.restassured.RestAssured.*;

public class Serialize {

    public static void main(String[] args) throws IOException{

        AddPlaceSerialize Add=new AddPlaceSerialize();
        LocationSerialize loc=new LocationSerialize();
        loc.setLat(-38.383494);
        loc.setLng(33.427362);
        Add.setLocation(loc);
        Add.setAccuracy(50);
        Add.setName("Frontline house");
        Add.setPhone_number("(+91) 983 893 3937");
        Add.setAddress("29, side layout, cohen 09");
        List<String> lst=new ArrayList<>();
        lst.add("shoe park");
        lst.add("shop");
        Add.setTypes(lst);
        Add.setWebsite("http://google.com");
        Add.setLanguage("French-IN");

        RestAssured.baseURI="https://rahulshettyacademy.com";

        Response response=given().log().all().queryParam("key", "qaclick123")
                .body(Add).when().post("/maps/api/place/add/json")
                .then().assertThat().statusCode(200).extract().response();

        String response_string=response.asString();
        System.out.println(response_string);


    }
}
