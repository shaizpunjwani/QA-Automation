package Utils;

import API.GetResponse;
import Loggers.Log;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.testng.Assert;

import java.util.List;

public class CheckDataTypes {

    Log log=new Log();

    private Boolean Verify_ID(List<Integer> id1, List<Integer> id2){
        Class<?> dataTypeID1 = null;
        Class<?> dataTypeID2 = null;
        dataTypeID1 = id1.get(0).getClass();
        dataTypeID2 = id2.get(0).getClass();
        if(dataTypeID1.equals(dataTypeID2)){
            return Boolean.TRUE;
        }
        else{
            return Boolean.FALSE;
        }
    }

    private Boolean Verify_String(List<String> id1, List<String> id2){
        Class<?> dataTypeID1 = null;
        Class<?> dataTypeID2 = null;
        dataTypeID1 = id1.get(0).getClass();
        dataTypeID2 = id2.get(0).getClass();
        if(dataTypeID1.equals(dataTypeID2)){
            return Boolean.TRUE;
        }
        else{
            return Boolean.FALSE;
        }
    }

    public void Verify_DataTypes(GetResponse get, GetResponse get2){
        if(Verify_ID(get.getIds(), get2.getIds()) & (Verify_String(get.getNames(), get2.getNames())) & (Verify_String(get.getGenders(), get2.getGenders())) & (Verify_String(get.getStatuses(), get2.getStatuses())) & (Verify_String(get.getEmails(), get2.getEmails()))){
            log.info("verified d types");
        }
        else{
            Assert.fail("failed");
            log.error("failed");
        }
    }

    public void Verify_Schema(GetResponse get, GetResponse get2) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        String expectedJson = objectMapper.writeValueAsString(get);
        String actualJson = objectMapper.writeValueAsString(get2);

        if (expectedJson.equals(actualJson)) {
            log.info("The schemas of the two objects are identical.");
        } else {
            log.error("The schemas of the two objects are different.");
        }
    }
}
