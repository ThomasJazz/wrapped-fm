/*
Summary:
    Example of a controller you can use
Author: Noctsol
CreatedDate: 2022-08-21

*/



/********************* INTERNAL PACKAGES *********************/
package fm.wrapped.aggregator.controller;
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
@RequestMapping(value = "/example-path",
    // method = { RequestMethod.GET, RequestMethod.POST },
    produces = MediaType.APPLICATION_JSON_VALUE
    )

// @RequestMapping(value = "/user/revert", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON)
// public ResponseEntity<UserResponse> revertUserData(@RequestParam(value = "userName") String userName){

public class ExampleController {

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


    @GetMapping(value = "ex-text")
    public String ApiCallingApi() {
        HttpClient client = HttpClient.newHttpClient();
        System.out.println("1");
        HttpRequest request = HttpRequest.newBuilder()
            .uri(URI.create("http://localhost:8081/example-path/ex-get?username=hello"))
            .GET()
            .build();

        System.out.println("2");
        var x = client.sendAsync(request, BodyHandlers.ofString())
            .thenApply(HttpResponse::body)
            .thenAccept(System.out::println)
            .join();System.out.println("2");

        System.out.println("3");

        return "hello";
    }
}
