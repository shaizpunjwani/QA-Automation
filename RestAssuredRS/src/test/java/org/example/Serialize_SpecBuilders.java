package org.example;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.asynchttpclient.RequestBuilder;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static io.restassured.RestAssured.given;

public class Serialize_SpecBuilders {

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

        RequestSpecification request=new RequestSpecBuilder().setBaseUri("https://rahulshettyacademy.com").addQueryParam("key", "qaclick123")
                .setContentType(ContentType.JSON).build();

        ResponseSpecification response_spec=new ResponseSpecBuilder().expectStatusCode(200).expectContentType(ContentType.JSON).build();


        RequestSpecification res=given().log().all().spec(request).body(Add);

        Response response=res.when().post("/maps/api/place/add/json")
                .then().log().all().spec(response_spec).extract().response();

        String response_string=response.asString();
        System.out.println(response_string);


    }
}
