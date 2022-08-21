package fm.wrapped.aggregator.controller;

// Imports from our project
import fm.wrapped.aggregator.entity.*;

// 3rd party imports
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/sample-api")
public class FirstController {

    @GetMapping("/get-welcome-message")
    public String HelloWorld()
    {
        return "Hello, world";
    }

    @PostMapping("/add-data")
    public void addData(@RequestBody SpotifyListen listen)
    {

    }

    @PutMapping("/add-data")
    public void updateSomething(@RequestBody SpotifyListen listen)
    {

    }


}
