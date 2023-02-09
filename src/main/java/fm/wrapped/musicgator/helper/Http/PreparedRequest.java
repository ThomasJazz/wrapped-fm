package fm.wrapped.musicgator.helper.Http;

/*
    Summary:
        Prepared Request to contain all prepared request info
    Author: Noctsol
    CreatedDate: 2022-08-22
*/

/*-------------------------------------------------------------- IMPORTS --------------------------------------------------------------*/

/********************* JAVA DEFAULT PACKAGES *********************/
// Java Native Data Structures
import java.util.Map;           // Map<type,type>
import java.util.Map.Entry;     // Map.Entry <type, type>
import java.util.HashMap;
import java.util.List;          // Map<type,type>

// Java.net.Http
import java.net.http.HttpRequest;

// Sprintboot
import org.springframework.web.util.UriComponentsBuilder;


/********************* CUSTOM PACKAGES *********************/
import fm.wrapped.musicgator.helper.Str;



/*-------------------------------------------------------------- CLASS --------------------------------------------------------------*/

public class PreparedRequest {
    /******************************************* PROPERTIES/ATTRIBUTES *******************************************/
    public String Uri;
    public Map<String, String> Headers;
    public Map<String, String> Params;
    public String Content;
    public long TimeoutMilliseconds;


    /******************************************* CONSTRUCTORS *******************************************/
    public PreparedRequest(){}

    public PreparedRequest(HttpRequest myRequest)
    {
        // Stripping the entire request down to something more easy to use

        // Getting the Uri
        this.Uri = myRequest.uri().toString();

        // Retrieving any parameters if they exist
        this.Params = UriComponentsBuilder
            .fromUriString(myRequest.uri().toString())
            .build()
            .getQueryParams()
            .toSingleValueMap();

        // Getting Headers
        Map<String, String> myActualHeaders = new HashMap<String, String>();
        for (Entry<String, List<String>> kv : myRequest.headers().map().entrySet()) {
            myActualHeaders.put(kv.getKey(), Str.join(kv.getValue()));
        }

        this.Headers = myActualHeaders;

        // Getting Timeout of Request
        // Kinda annoying - Had to convert Optional<Duration> to Duration to milliseconds
        this.TimeoutMilliseconds = myRequest.timeout().get().toMillis();

    }
}
