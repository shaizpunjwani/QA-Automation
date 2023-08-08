package API;

import Loggers.Log;
import Utils.SpecBuilder;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import static io.restassured.RestAssured.given;

public class GetAPI {

    Log log=new Log();

    public String GetAPIResponse(RequestSpecification request, ResponseSpecification resp, String resource) {


        RequestSpecification res = given().log().all().spec(request);

        Response response = res.when().get(resource)
                .then().log().all().spec(resp).extract().response();

        String response_string = response.asString();
        log.info("url:");
        log.info(RestAssured.baseURI+resource);
        return response_string;
    }
}
