package Utils;

import API.APiManager;
import Endpoints.Endpoint;

public class TestContextSetup {

    public APiManager apimanager;
    public SpecBuilder spec;
    public CheckStatus chk_status;
    public CheckDataTypes chk_dt;
    public Endpoint endpoint;

    public int id;

    public TestContextSetup(){
        apimanager=new APiManager();
        spec=new SpecBuilder();
        chk_status=new CheckStatus();
        chk_dt=new CheckDataTypes();
        endpoint=new Endpoint();
    }
}
