import io.restassured.path.json.JsonPath;
import org.openqa.selenium.json.Json;

import java.io.IOException;

import static io.restassured.RestAssured.*;

public class GraphQL {

    public static void main(String[] args) throws IOException{

        System.out.println("query graphql");
        int charc_id=11;
        int loc_id=8;

       String response= given().log().all().header("Content-Type", "application/json")
            .body("{\n" +
                    "\"query\": \n" +
                    "\"query($characterId: Int!, $locationId: Int!)\\n{\\n  character(characterId: $characterId) {\\n    name\\n    gender\\n  }\\n  location(locationId: $locationId) {\\n    name\\n    dimension\\n  }\\n  episode(episodeId: 1) {\\n    name\\n    air_date\\n  }\\n  characters(filters: {name: \\\"Rahul\\\"}) {\\n    info {\\n      count\\n      pages\\n    }\\n    result {\\n      name\\n      type\\n    }\\n  }\\n  episodes(filters: {episode: \\\"netflix\\\"}) {\\n    result {\\n      id\\n      name\\n      episode\\n    }\\n  }\\n}\",\n" +
                    "\"variables\"\n" +
                    ": \n" +
                    "{\"characterId\": "+charc_id+", \"locationId\": "+loc_id+"},\n" +
                    "\"characterId\"\n" +
                    ": \n" +
                    "11,\n" +
                    "\"locationId\"\n" +
                    ": \n" +
                    "8}")
                    .when().post("https://rahulshettyacademy.com/gq/graphql")
                    .then().extract().response().asString();

        JsonPath js=new JsonPath(response);
        System.out.println(js.getString("data.character.name"));

        System.out.println("mutation graphql");

        int loc=1575;
        String repsonse_2=given().log().all().header("Content-Type", "application/json")
                .body("{\n" +
                        "\"query\"\n" +
                        ": \n" +
                        "\"mutation($locname: String!, $characname: String!, $epname: String!){\\n  createLocation(location: {name: $locname, type: \\\"south\\\", dimension: \\\"250\\\"})\\n  {\\n    id\\n  }\\n  createCharacter(character: {name: $characname, type: \\\"chut\\\", status: \\\"alive\\\", species: \\\"human\\\", gender: \\\"M\\\", image: \\\"img1.png\\\", originId:1535, locationId: 1535})\\n  {\\n    id\\n  }\\n  createEpisode(episode: {name: $epname, air_date: \\\"1-1-2023\\\", episode: \\\"2\\\"})\\n  {\\n    id\\n  }\\n  deleteLocations(locationIds: ["+loc+"]){\\n    locationsDeleted\\n  }\\n}\",\n" +
                        "\"variables\"\n" +
                        ": \n" +
                        "{\"locname\": \"pak\", \"characname\": \"robin\", \"epname\": \"sp\"}}")
                .when().post("https://rahulshettyacademy.com/gq/graphql").then().extract().response().asString();

        JsonPath js_mut=new JsonPath(repsonse_2);
        System.out.println(js_mut.getString("data.createLocation.id"));
        loc++;
    }
}
