/*
Summary:
    Explos
Author: Noctsol
CreatedDate: 2022-08-21

*/



/********************* INTERNAL PACKAGES *********************/
package fm.wrapped.aggregator.controller;


/********************* PUBLIC PACKAGES *********************/
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse.BodyHandlers;
import java.net.http.HttpResponse;

import org.springframework.http.MediaType;
/********************* PREBUILT PACKAGES *********************/
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import fm.wrapped.aggregator.example.ExampleClass;
import io.github.cdimascio.dotenv.Dotenv;



@RestController
@RequestMapping(value = "/test",
    // method = { RequestMethod.GET, RequestMethod.POST },
    produces = MediaType.APPLICATION_JSON_VALUE
    )

// @RequestMapping(value = "/user/revert", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON)
// public ResponseEntity<UserResponse> revertUserData(@RequestParam(value = "userName") String userName){

public class TestController {

    // Get Call that requires the paramer of username
    @GetMapping(value = "ex-get")
    public ExampleClass GetTest(@RequestParam(value = "username") String someUser)
    {
        // Dotenv dotenv = Dotenv.load();
        Dotenv dotenv = Dotenv.load();

        System.out.println(dotenv.get("test"));

        ExampleClass myClass = new ExampleClass(someUser);
        return myClass;
    }

    // Post call
    @PostMapping(value = "ex-post")
    public ExampleClass PostTest()
    {

        ExampleClass myClass = new ExampleClass();
        return myClass;
    }

}
