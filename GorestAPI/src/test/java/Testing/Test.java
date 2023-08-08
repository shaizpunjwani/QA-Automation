package Testing;


import API.GetAPI;
import API.GetResponse;
import Loggers.Log;
import PayLoads.PayLoad;

import Property.PropertyReader;
import Utils.CheckDataTypes;
import Utils.TestContextSetup;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.testng.annotations.BeforeClass;

import java.io.IOException;

public class Test {

    Log log=new Log();

    TestContextSetup tcs;
    public GetAPI fetch;
    public CheckDataTypes check;
    GetResponse get=new GetResponse();
    GetResponse get2=new GetResponse();
    //CheckDataTypes check=new CheckDataTypes();



    @BeforeClass
    public void LoadFile() throws IOException {
        this.tcs = new TestContextSetup();
//        API ka object
        fetch=tcs.apimanager.FetchingData();
        check=tcs.chk_dt;
        PropertyReader pr=new PropertyReader();
        String response= fetch.GetAPIResponse(tcs.spec.GetReq(pr.GetValue("url")), tcs.spec.GetResp(),tcs.endpoint.Get_Resource_Url());
        log.info("fetching data");
        get.GetGson(response);
    }

    @org.testng.annotations.Test(priority = 1, description = "verify status")
    public void Fetch_Json(){
        log.info("veryfing status");
        tcs.chk_status.Verify_Status(get.getStatuses());
    }

    @org.testng.annotations.Test(priority = 2, description = "verify data types")
    public void Verify_Types() throws JsonProcessingException {
        log.info("veryfing types");
        log.info("getting the expected output");
        get2.GetGson(PayLoad.Get_Resp());
        check.Verify_DataTypes(get, get2);
    }
    @org.testng.annotations.Test(priority = 3, description = "verify schemas")
    public void Verify_Schemas() throws JsonProcessingException {
        log.info("checking schemas");
        check.Verify_Schema(get, get2);
    }
}
