import Files.PayLoad;
import io.restassured.path.json.JsonPath;
import org.testng.Assert;

public class ComplexJsonParse {

//    Queries to be solved
//    1. Print No of courses returned by API
//
//    2.Print Purchase Amount
//
//    3. Print Title of the first course
//
//    4. Print All course titles and their respective Prices
//
//    5. Print no of copies sold by RPA Course
//
//    6. Verify if Sum of all Course prices matches with Purchase Amount

    public static void main(String[] args){

        JsonPath js=new JsonPath(PayLoad.GetCourses());
        //    1. Print No of courses returned by API
        //Note: kyuin ka courses ke sath array ha [] so ham ne usko pehle as key extract kia and then
        //since array so we used courses.size()
        System.out.println("no of courses");
        System.out.println(js.getInt("courses.size()"));

        //    2.Print Purchase Amount
        // since the purchase amount is in int so i will use the js.getInt and it also had dashboard as parent so the path will be dashboard.purchaseamount
        System.out.println("purchase amount");
        System.out.println(js.getInt("dashboard.purchaseAmount"));

        //    3. Print Title of the first course
        // i just gave the path to get title courses parent then selected index courses[0].title
        System.out.println("title of first course");
        System.out.println(js.get("courses[0].title"));

        //    4. Print All course titles and their respective Prices
        System.out.println("printing all courses along with prices");

        for(int i=0; i<js.getInt("courses.size()"); i++){
            System.out.println("course title: "+js.get("courses["+i+"].title"));
            System.out.println("course price: "+js.get("courses["+i+"].price"));
        }

        //    5. Print no of copies sold by RPA Course
        System.out.println("no of copies sold by RPA");

        for(int i=0; i<js.getInt("courses.size()"); i++){
            String title=js.get("courses["+i+"].title").toString();
            if(title.equals("RPA")){
                System.out.println(js.get("courses["+i+"].copies"));
            }
        }
        //    6. Verify if Sum of all Course prices matches with Purchase Amount

//        refer to SumCourses class as this case is real world scenario so we will be using
//                testng annotations in it
    }
}
