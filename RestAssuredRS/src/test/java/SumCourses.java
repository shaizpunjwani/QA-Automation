import Files.PayLoad;
import JsonsPaths.Rawtojson;
import io.restassured.path.json.JsonPath;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SumCourses {

    @Test
    public void VerifySumprices(){
        int courseprices=0;
        JsonPath js=new JsonPath(PayLoad.GetCourses());
        System.out.println("verifying all course prices with purchase amount");
        for(int i = 0; i<js.getInt("courses.size()"); i++){
            courseprices=courseprices+(js.getInt("courses["+i+"].price"))*(js.getInt("courses["+i+"].copies"));
        }
        int originalprice=js.getInt("dashboard.purchaseAmount");
        Assert.assertEquals(originalprice, courseprices);
        System.out.println(courseprices);
    }
}
