package fm.wrapped.aggregator.lib.Http;

/*
    Summary:
        Easy Http Client made to make API calls using java.net.http as its underlying basis.

        Breakdown of Potential Overloads Matrix
        1     1    1
        null null null
        null  1    1
        null null  1
        1    null null
        1     1   null
        null null  1
        null  1    1

    Author: Noctsol
    CreatedDate: 2022-08-22
*/

/*-------------------------------------------------------------- IMPORTS --------------------------------------------------------------*/

/********************* JAVA DEFAULT CLASSES *********************/
// Java Native Data Structures
import java.util.Map;           // Map<type,type>
import java.util.Map.Entry;     // Entry<Type.Type> items inside Map

// Java Helper Packages
import java.time.Duration;      // Imports Duration functionality

// Spring Boot
import org.springframework.scheduling.annotation.Async;                 // Import the @Async tag functionallity
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


/********************** LOCAL LIBRARIES *********************/

/********************* PUBLIC PACKAGES *********************/



/*-------------------------------------------------------------- CLASS --------------------------------------------------------------*/
@SpringBootApplication
@EnableAsync
public class Client {
    /******************************************* PROPERTIES/ATTRIBUTES *******************************************/
    public HttpClient JavaClient;
    public Session Session;
    public Map<String, String> DefaultHeaders;
    public int TimeoutSeconds = 60;


    /******************************************* CONSTRUCTORS *******************************************/
    // Default Constructor just builds a new Http Client
    public Client() {
        HttpClient client = HttpClient.newHttpClient();
        this.JavaClient = client;
    }

    // Secondary Constructor implementing Sessions
    public Client(Session session) {
        HttpClient client = HttpClient.newHttpClient();
        this.Session = session;
        this.JavaClient = client;
    }


    /******************************************* PUBLIC METHODS *******************************************/

    // Makes a GET Request
    public Request get(String uri,
        Map<String, String> myHeaders,
        Map<String, String> myParams,
        String myContent   ) throws Exception {

        // Building Request
        HttpRequest myReq = this.makeRequest(Method.GET, uri, myHeaders, myParams, myContent);

        // Sending Request
        HttpResponse<String> response = this.JavaClient.send(myReq, BodyHandlers.ofString());

        // Maps the The HttpResponse object into the easier custom Request class
        Request req = new Request(response);

        return req;
    }

    // // Makes a GET Request, Auto serializes an object, and will auto deserialize to another
    // public <TypeIn, TypeOut> Request<T> get(String uri,
    //     Map<String, String> myHeaders,
    //     Map<String, String> myParams,
    //     String myContent   ) throws Exception {

    //     // Building Request
    //     HttpRequest myReq = this.makeRequest(Method.GET, uri, myHeaders, myParams, myContent);

    //     // Sending Request
    //     HttpResponse<String> response = this.JavaClient.send(myReq, BodyHandlers.ofString());

    //     // Maps the The HttpResponse object into the easier custom Request class
    //     Request<String> req = new Request<String>(response);

    //     return req;
    // }





    // // Overload1 - Makes a GET Request but auto serializes an object into JSON
    // public <T> Request<String> get(String uri,
    //     Map<String, String> myHeaders,
    //     Map<String, String> myParams,
    //     T myContentObject   ) throws Exception {

    //     // Building Request
    //     HttpRequest myReq = this.makeRequest(Method.GET, uri, myHeaders, myParams, myContentObject);

    //     // Sending Request
    //     HttpResponse<String> response = this.JavaClient.send(myReq, BodyHandlers.ofString());

    //     // Maps the The HttpResponse object into the easier custom Request class
    //     Request<String> req = new Request<String>(response);

    //     return req;
    // }

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
        String myContent) {

        // Build URL - Really didn't feel like writing my own code for this to deal with special chars
        UriComponentsBuilder myUriCBuilder = UriComponentsBuilder.fromUriString(uri);

        // (Optional) Adding params to URL
        if (myParams != null){
            for (Entry<String,String>  i: myParams.entrySet()) {
                    myUriCBuilder.queryParam(i.getKey(), i.getValue());
                }
        }

        // myUriCBuilder.port(8081);

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

        // Adding headers from session
        if (this.Session != null){
            for (Entry<String,String>  i: this.Session.Headers.entrySet()) {
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

    // Returns a Builder object - AUTO Serializes Given object into Json
    // public <T> HttpRequest makeRequest(
    //     Method myMethod,
    //     String uri,
    //     Map<String, String> myHeaders,
    //     Map<String, String> myParams,
    //     T myContentObject) throws Exception {

    //     // Build URL - Really didn't feel like writing my own code for this to deal with special chars
    //     UriComponentsBuilder myUriCBuilder = UriComponentsBuilder.fromUriString(uri);

    //     // (Optional) Adding params to URL
    //     if (myParams != null){
    //         for (Entry<String,String>  i: myParams.entrySet()) {
    //                 myUriCBuilder.queryParam(i.getKey(), i.getValue());
    //             }
    //     }

    //     // Convering URI Object to a string
    //     String uriString =  myUriCBuilder.toUriString();

    //     // Create URI Object (Blame Java for this)
    //     URI myUri = URI.create(uriString);


    //     // Create Http Builder Object
    //     Builder myBuilder = HttpRequest.newBuilder();
    //     myBuilder.timeout(Duration.ofSeconds(this.TimeoutSeconds));  // Adding Timeout

    //     // Add URI
    //     myBuilder.uri(myUri);

    //     // Adding headers
    //     if (myHeaders != null){
    //         for (Entry<String,String>  i: myHeaders.entrySet()) {
    //                 myBuilder.header(i.getKey(), i.getValue());
    //             }
    //     }


    //     String myTempContent = "";
    //     // Handling for case when the object is a string
    //     if (myContentObject instanceof String ) {
    //         myTempContent = myContentObject.toString();
    //     }
    //     // Else just serialize the whole thing
    //     else {
    //         ObjectMapper mapper = new ObjectMapper();
    //         myTempContent = mapper.writeValueAsString(myContentObject);
    //     }


    //     // Formatting Content
    //     BodyPublisher fContent = HttpRequest.BodyPublishers.ofString(myTempContent);

    //     // Adding Method and Content to Request
    //     myBuilder.method(myMethod.toString(), fContent);

    //     // Create the actual Request object
    //     HttpRequest myRequest =  myBuilder.build();

    //     return myRequest;
    // }

}
