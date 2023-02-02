package fm.wrapped.aggregator.controller;

/*
    Summary:
        Controller left up here to just test out code
    Author: Noctsol
    CreatedDate: 2022-08-21
*/

import org.springframework.http.MediaType;
/********************* JAVA DEFAULT CLASSES *********************/
import java.util.HashMap;       // HashMap<String,String>


import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpHeaders;


/********************* PUBLIC PACKAGES *********************/
import com.fasterxml.jackson.databind.ObjectMapper;


/********************* * LOCAL LIBRARIES *********************/
import fm.wrapped.aggregator.model.TestUser;


@RestController
@RequestMapping(value = "api/v1/test",
    // method = { RequestMethod.GET, RequestMethod.POST },
    produces = MediaType.APPLICATION_JSON_VALUE
    )

// @RequestMapping(value = "/user/revert", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON)
// public ResponseEntity<UserResponse> revertUserData(@RequestParam(value = "userName") String userName){

public class TestController {

    // Get Call that requires the paramer of username
    @GetMapping(value = "user")
    public ResponseEntity<String> GetUser(
        @RequestParam(value = "user_id") String userId,
        @RequestParam(value = "format") String format) throws Exception
    {
        ObjectMapper mapper = new ObjectMapper();
        TestUser myTestUser = new TestUser().GenerateTestInstance();

        String body = mapper.writeValueAsString(myTestUser);

        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.set("myheader", "somecrazyvalue");

        ResponseEntity<String> theirResponse = ResponseEntity.ok()
                            .headers(responseHeaders)
                            .body(body);

        return theirResponse;
    }

    @GetMapping(value = "user2")
    public ResponseEntity<String> GetUser2(
        @RequestParam(value = "user_id") String userId,
        @RequestParam(value = "format") String format) throws Exception
    {
        ObjectMapper mapper = new ObjectMapper();
        HashMap<String, String> hMap = new HashMap<String, String>();
        hMap.put("user_id", userId);
        hMap.put("format", format);

        String body = mapper.writeValueAsString(hMap);

        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.set("myheader", "somecrazyvalue");

        ResponseEntity<String> theirResponse = ResponseEntity.ok()
                            .headers(responseHeaders)
                            .body(body);

        return theirResponse;
    }

}
