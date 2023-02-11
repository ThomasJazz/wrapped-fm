package fm.wrapped.musicgator.helper.Http;

/*
    Summary:
        This class is used to add default Authorization and Headers to the Custom Http Client.

    Author: Noctsol
    CreatedDate: 2022-08-22
*/

/*-------------------------------------------------------------- IMPORTS --------------------------------------------------------------*/

/********************* JAVA DEFAULT CLASSES *********************/
// Java Native Data Structures
import java.util.Map;           // Map<type,type>
import java.util.HashMap;       // HashMap<type,type>
import java.util.Base64;        // Base 64 Encoding


/*-------------------------------------------------------------- CLASS --------------------------------------------------------------*/

public class Session {
    /******************************************* PROPERTIES/ATTRIBUTES *******************************************/
    public Map<String, String> Headers;
    public String[] Authorization;


    /******************************************* CONSTRUCTOR *******************************************/

    // Default Constructor
    public Session(){
        this.Headers = new HashMap<String, String>();
    }


    /******************************************* PUBLIC METHODS *******************************************/
    // Add an entry into the headers
    public Session addHeader(String name, String value){

        // Add name and value to Headers
        this.Headers.put(name, value);

        return this;
    }

    // Adds a new map as the headers that will be used
    public Session addHeaders(Map<String, String> myHeaders){

        // Set Headers
        this.Headers = myHeaders;

        return this;
    }

    // Adds a Base64 Encoded Auth Sring to the ehaders
    public Session addAuth(String user, String password){

        // Forming username:password
        String credentials = user + ":" + password;

        // Encoding String
        String encodedString = Base64.getEncoder().encodeToString(credentials.getBytes());

        // Forming Auth Header
        String auth = "Basic " + encodedString;

        // Add to headers
        this.Headers.put("Authorization", auth);

        return this;
    }


}
