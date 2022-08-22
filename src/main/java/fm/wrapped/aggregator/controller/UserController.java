package fm.wrapped.aggregator.controller;

// Imports from our project
import fm.wrapped.aggregator.entity.*;

// 3rd party imports
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    @PostMapping("/add")
    public void addUserAccount(@RequestBody UserAccount account)
    {

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
