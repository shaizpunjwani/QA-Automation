package Utils;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class SpecBuilder {

    public RequestSpecification GetReq(String base){

        RequestSpecification request=new RequestSpecBuilder().setBaseUri(base).addHeader("Accept", "application/json")
                .addHeader("Content-Type", "application/json")
                .addHeader("Authorization", "Bearer8f3aef254caf90c5d9f5f070363fddd0823910157cbcfd1842150355603466e8")
                .setContentType(ContentType.JSON).build();
        return request;
    }

    public ResponseSpecification GetResp(){
        ResponseSpecification response_spec=new ResponseSpecBuilder().expectStatusCode(200).expectContentType(ContentType.JSON).build();
        return response_spec;
    }
}
