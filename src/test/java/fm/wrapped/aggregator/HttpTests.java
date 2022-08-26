package fm.wrapped.aggregator;

/*
    Summary:
        For Testing the Http Cient I made

    Author: Noctsol
    CreatedDate: 2022-08-23
*/

/*-------------------------------------------------------------- IMPORTS --------------------------------------------------------------*/

/********************* JAVA DEFAULT CLASSES *********************/
// Java Native Data Structures
import java.util.Map;           // Map<type,type>
import java.util.HashMap;       // HashMap<String,String>

// UnitTesting
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.springframework.boot.test.context.SpringBootTest;

/********************* PUBLIC PACKAGES *********************/

/********************* LOCAL LIBRARIES *********************/
import fm.wrapped.aggregator.lib.Http.Client;
import fm.wrapped.aggregator.lib.Http.Session;
import fm.wrapped.aggregator.lib.Http.Request;


/*-------------------------------------------------------------- CLASS --------------------------------------------------------------*/
@SpringBootTest
public class HttpTests {
    /******************************************* PROPERTIES *******************************************/
    public Map<String,String> TestParameters;
    public Map<String,String> TestHeaders;
    public Session TestSession;
    public String URI = "http://localhost:8081/api/v1/tests/user";

    /******************************************* METHOD *******************************************/

    public Session TestSession(){
        Session sesh = new Session()
            .addHeader("should-exist", "it-exists")
            .addAuth("someuser", "uselesspassword");
        return sesh;
    }

    public Map<String,String> TestParameters(){
        Map<String, String> parameters = new HashMap<String, String>();
        parameters.put("user_id", "TOTALLY-NOT-AN-ID");
        parameters.put("format", "json");

        return parameters;
    }

    public Map<String,String> TestHeaders(){
        Map<String, String> headers = new HashMap<String, String>();
        headers.put("runtime-string", "value1");
        headers.put("runtime-key", "my-api-key-value");

        return headers;
    }


    /******************************************* TESTS *******************************************/

    @Test
    public void test1() throws Exception{
        Client myClient = new Client(TestSession());
        String myBody = "{\"user_id\":\"TOTALLY-NOT-AN-ID\",\"format\":\"json\"}";
        Request myResponse = myClient.get(this.URI,
            TestHeaders(),
            TestParameters(),
            myBody);

        assertEquals(200, myResponse.StatusCode);

    }



}
