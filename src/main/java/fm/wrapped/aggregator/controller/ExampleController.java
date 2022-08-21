package fm.wrapped.aggregator.controller;

import fm.wrapped.aggregator.example.ClassExample;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
// @RequestMapping("/example-endpoint")

// @RequestMapping(value = "/user/revert", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON)
// public ResponseEntity<UserResponse> revertUserData(@RequestParam(value = "userName") String userName){

public class ExampleController {

    @GetMapping(value = "test-kevin")
    public ClassExample Test()
    {

        ClassExample shit = new ClassExample("fuck");
        return shit;
    }
}
