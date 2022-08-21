package fm.wrapped.aggregator.controller;

// Imports from our project
import fm.wrapped.aggregator.entity.*;

// 3rd party imports
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/sample-endpoint")
public class FirstController {

    @GetMapping("/get-welcome-message")
    public String HelloWorld()
    {
        return "Hello, world";
    }

    @PostMapping("/post-data")
    public void addData(@RequestBody SpotifyListen listen)
    {

    }


}
