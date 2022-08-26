package fm.wrapped.aggregator.lib.Http;

/*
    Summary:
        Quick Class to contain strip java.net.http.HttpResponse into an easier to use class called Request

    Author: Noctsol
    CreatedDate: 2022-08-22
*/

/*-------------------------------------------------------------- IMPORTS --------------------------------------------------------------*/

/********************* JAVA DEFAULT CLASSES *********************/
// Java Native Data Structures
import java.util.Map;           // Map<type,type>
import java.util.HashMap;       // HashMap<type,type>
import java.util.Map.Entry;     // Map.Entry<type,type>
import java.util.List;          // List<type>


// Java Native HTTP Client
import java.net.http.HttpResponse;


/********************* CUSTOM PACKAGES *********************/
import fm.wrapped.aggregator.lib.Helper.Str;


/*-------------------------------------------------------------- CLASS --------------------------------------------------------------*/

public class Request {
    /******************************************* PROPERTIES/ATTRIBUTES *******************************************/
    public PreparedRequest PreparedRequest;
    public int StatusCode;
    public String Uri;
    public Map<String, String> Headers;
    public String Content;


    /******************************************* CONSTRUCTORS *******************************************/
    // Default Constructor strips java.net.http.HttpResponse
    public Request(HttpResponse<String> myResponse){

        // Setting Prepared request object
        this.PreparedRequest = new PreparedRequest(myResponse.request());

        // Setting status code
        this.StatusCode = myResponse.statusCode();

        // Setting Uri
        this.Uri = myResponse.uri().toString();

        // Getting Content
        this.Content = myResponse.body().toString();

        // Map Content to object - functionality not up right now

        // Getting Headers
        Map<String, String> myActualHeaders = new HashMap<String, String>();
        for (Entry<String, List<String>> kv : myResponse.headers().map().entrySet()) {
            myActualHeaders.put(kv.getKey(), Str.join(kv.getValue()));
        }
    }

    // Constructor in case you want to instantiate an empty instance
    public Request(){}

    /******************************************* CONSTRUCTORS *******************************************/

}
