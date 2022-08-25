package fm.wrapped.aggregator;



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
import java.util.List;          // Map<type,type>
import java.util.Arrays;        // List<?>


// Java Helper Packages
import java.time.Duration;      // Imports Duration functionality

// Spring Boot
// import org.springframework.http.MediaType;
import org.springframework.scheduling.annotation.Async;                 // Import the @Async tag functionallity
// import org.springframework.beans.factory.annotation.Value;           // @Value
import org.springframework.scheduling.annotation.EnableAsync;           // Allows you to @EnableAsync
import org.springframework.web.util.UriComponentsBuilder;               // UriComponentsBuilder - Builds URL

import fm.wrapped.aggregator.lib.Helper.Str;

import org.springframework.boot.autoconfigure.SpringBootApplication;    // Allows you to @SpringBootApplication
import org.junit.jupiter.api.Test;
import org.springframework.util.Assert.*;

import org.springframework.boot.test.context.SpringBootTest;

// Java Http .net Http Client
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpRequest.BodyPublisher;
import java.net.http.HttpRequest.Builder;
// import java.net.http.HttpResponse.BodyHandler;
import java.net.http.HttpResponse.BodyHandlers;
import java.net.http.HttpResponse;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.net.URI;



/********************* INTERNAL PACKAGES *********************/



/********************* PUBLIC PACKAGES *********************/



@SpringBootTest
class HelperStrTests {


    // Test Helper.Str Join functionality with no delimiter
    @Test
    void shouldJoinListOfStringsWithNoDelimiter() {
        String expectedString = "";

        // Initializing a list
        List<String> myList = Arrays.asList("i", "am", "joined");

        for (String word : myList) {
            expectedString+=word;
        }

        // Joining String
        String resultString = Str.join(myList);

        assertEquals(expectedString, resultString);
    }

    // Test Helper.Str Join functionality with delimited
    @Test
    void shouldJoinListOfStringsWithDelimiter() {
        String expectedString = "i-am-joined";

        // Initializing a list
        List<String> myList = Arrays.asList("i", "am", "joined");

        // Joining String
        String resultString = Str.join(myList, "-");

        assertEquals(expectedString, resultString);
    }


}
