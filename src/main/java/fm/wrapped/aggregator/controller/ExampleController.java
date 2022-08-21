/*
Summary:
    Example of a controller you can use
Author: Noctsol
CreatedDate: 2022-08-21

*/



/********************* INTERNAL PACKAGES *********************/
package fm.wrapped.aggregator.controller;
import fm.wrapped.aggregator.example.ExampleClass;


/********************* PUBLIC PACKAGES *********************/
import com.fasterxml.jackson.core.*;
import io.github.cdimascio.dotenv.Dotenv;

/********************* PREBUILT PACKAGES *********************/
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;




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
}
