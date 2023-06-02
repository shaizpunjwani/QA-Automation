import JsonsPaths.Rawtojson;
import io.restassured.RestAssured;
import io.restassured.filter.session.SessionFilter;
import io.restassured.path.json.JsonPath;
import org.testng.Assert;

import java.io.File;

import static io.restassured.RestAssured.*;

public class JiraTest {

    public static void main(String[] args){

        RestAssured.baseURI="http://localhost:8080";

        System.out.println("Authenticate");

        SessionFilter session=new SessionFilter();

        String response= given().log().all().header("Content-Type", "application/json")
                        .body("{ \"username\": \"shaiz\", \"password\": \"vivov11pro\" }")
                        .filter(session)
                        .when().post("/rest/auth/1/session")
                        .then().log().all().extract().response().asString();


        System.out.println("Adding Comment");
        String msg="I have made my comment";

        String addcomment=given().log().all().pathParam("key", "10103").header("Content-Type", "application/json")
                .body("{\n" +
                        "    \"body\": \""+msg+"\",\n" +
                        "    \"visibility\": {\n" +
                        "        \"type\": \"role\",\n" +
                        "        \"value\": \"Administrators\"\n" +
                        "    }\n" +
                        "}").filter(session)
                .when().post("/rest/api/2/issue/{key}/comment").then().log().all().assertThat().statusCode(201).extract().response().asString();

        JsonPath js=new JsonPath(addcomment);
        int commentid=js.getInt("id");
        System.out.println(commentid);

        System.out.println("Adding attachments");

        given().pathParam("key", "10103").log().all().header("X-Atlassian-Token", "no-check").header("Content-Type", "multipart/form-data")
                .filter(session)
                .multiPart("file", new File("jira.txt"))
                .when().post("/rest/api/2/issue/{key}/attachments")
                .then().log().all().assertThat().statusCode(200);


        System.out.println("Get Issue");

        String issuedetails=given().log().all().pathParam("key", "10103").queryParam("fields", "comment").filter(session).when().get("/rest/api/2/issue/{key}")
                .then().log().all().assertThat().statusCode(200).extract().response().asString();

        //System.out.println(issuedetails);

        JsonPath js1=new JsonPath(issuedetails);
        int Commentscount=js1.getInt("fields.comment.comments.size()");

        for(int i=0; i<Commentscount; i++){
            if((js1.getInt("fields.comment.comments["+i+"].id"))==commentid){
                Assert.assertEquals(msg,js1.get("fields.comment.comments["+i+"].body"));
            }
        }
    }
}
