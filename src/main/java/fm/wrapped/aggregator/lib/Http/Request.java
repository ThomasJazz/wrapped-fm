package fm.wrapped.aggregator.lib.Http;



/*
    Summary:
        Quick Class to contain All Request Info
    Author: Noctsol
    CreatedDate: 2022-08-22

*/



/********************* PREBUILT PACKAGES *********************/
// Java Native Data Structures
import java.util.Map;           // Map<type,type>

import java.net.http.HttpRequest;
import org.springframework.web.util.UriUtils;


public class Request {
    public PreparedRequest PreparedRequest;
    public int StatusCode;
    public Map<String, String> Headers;
    public String Content;

    public Request(){}

    public Request(HttpRequest myRequest){
    }
}
