package fm.wrapped.aggregator.lib.Http;

/*
    Summary:
        Easy Http Client made to make API calls.
    Author: Noctsol
    CreatedDate: 2022-08-22

*/

/********************* PREBUILT PACKAGES *********************/
// Java Native Data Structures
import java.util.Map;           // Map<type,type>
import java.util.Map.Entry;     // Entry<Type.Type> items inside Map

// Java Helper Packages
import java.time.Duration;      // Imports Duration functionality

// Spring Boot
// import org.springframework.http.MediaType;
import org.springframework.scheduling.annotation.Async;                 // Import the @Async tag functionallity
// import org.springframework.beans.factory.annotation.Value;           // @Value
import org.springframework.scheduling.annotation.EnableAsync;           // Allows you to @EnableAsync
import org.springframework.web.util.UriComponentsBuilder;               // UriComponentsBuilder - Builds URL
import org.springframework.boot.autoconfigure.SpringBootApplication;    // Allows you to @SpringBootApplication

// Java Http .net Http Client
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpRequest.BodyPublisher;
import java.net.http.HttpRequest.Builder;
// import java.net.http.HttpResponse.BodyHandler;
import java.net.http.HttpResponse.BodyHandlers;
import java.net.http.HttpResponse;
import java.net.URI;



/********************* INTERNAL PACKAGES *********************/



/********************* PUBLIC PACKAGES *********************/





@SpringBootApplication
@EnableAsync
public class Client {
    /******************************************* PREBUILT PACKAGES *******************************************/
    public HttpClient JavaClient;
    public Session Session;
    public Map<String, String> DefaultHeaders;
    public int TimeoutSeconds = 60;


    /******************************************* PREBUILT PACKAGES *******************************************/
    public Client() {
        HttpClient client = HttpClient.newHttpClient();
        this.JavaClient = client;
    }

    public Client(Session session) {
        HttpClient client = HttpClient.newHttpClient();
        this.JavaClient = client;
    }

    /*
     1     1    1
     null null null

     null 1    1
     null null 1
     1    null null
     1    1  null
     null null 1
     null  1   1

     */

    /******************************************* PUBLIC METHODS *******************************************/
    public HttpResponse<String> get(String uri,
        Map<String, String> myHeaders,
        Map<String, String> myParams,
        Map<String, String> myContent   ) throws Exception {

        // Building Request
        HttpRequest myReq = this.makeRequest(Method.GET, uri, myHeaders, myParams, myContent);

        // Sending Request
        HttpResponse<String> response = this.JavaClient.send(myReq, BodyHandlers.ofString());

        return response;
    }

    // public HttpResponse<String> get(String uri) throws Exception {

    //     // Building Request
    //     HttpRequest myReq = this.makeRequest(Method.GET, uri, null, null, null);

    //     // Sending Request
    //     HttpResponse<String> response = this.JavaClient.send(myReq, BodyHandlers.ofString());

    //     return response;
    // }


    // public HttpResponse<String> get(String uri,
    //     Map<String, String> myParams
    //     ) throws Exception {

    //     // Building Request
    //     HttpRequest myReq = this.makeRequest(Method.GET, uri, null, myParams, null);

    //     // Sending Request
    //     HttpResponse<String> response = this.JavaClient.send(myReq, BodyHandlers.ofString());

    //     return response;
    // }



    @Async
    public void getAsync() throws Exception {}


    public void Post() throws Exception {}

    @Async
    public void postAsync() throws Exception {}


    public void put() throws Exception {}

    @Async
    public void putAsync() throws Exception {}


    public void send() throws Exception {}

    @Async
    public void sendAsync() throws Exception {}

    // Returns a Builder object ready to be built
    public HttpRequest makeRequest(
        Method myMethod,
        String uri,
        Map<String, String> myHeaders,
        Map<String, String> myParams,
        Map<String, String> myContent) {

        // Build URL - Really didn't feel like writing my own code for this to deal with special chars
        UriComponentsBuilder myUriCBuilder = UriComponentsBuilder.fromUriString(uri);

        // (Optional) Adding params to URL
        if (myParams != null){
            for (Entry<String,String>  i: myParams.entrySet()) {
                    myUriCBuilder.queryParam(i.getKey(), i.getValue());
                }
        }

        // Convering URI Object to a string
        String uriString =  myUriCBuilder.toUriString();

        // Create URI Object (Blame Java for this)
        URI myUri = URI.create(uriString);


        // Create Http Builder Object
        Builder myBuilder = HttpRequest.newBuilder();
        myBuilder.timeout(Duration.ofSeconds(this.TimeoutSeconds));  // Adding Timeout

        // Add URI
        myBuilder.uri(myUri);

        // Adding headers
        if (myHeaders != null){
            for (Entry<String,String>  i: myHeaders.entrySet()) {
                    myBuilder.header(i.getKey(), i.getValue());
                }
        }

        // Formatting Content
        BodyPublisher fContent = HttpRequest.BodyPublishers.ofString(myContent.toString());

        // Adding Method and Content to Request
        myBuilder.method(myMethod.toString(), fContent);

        // Create the actual Request object
        HttpRequest myRequest =  myBuilder.build();

        return myRequest;
    }

}
