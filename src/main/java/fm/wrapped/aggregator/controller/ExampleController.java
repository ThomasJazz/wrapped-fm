package fm.wrapped.aggregator.controller;

import fm.wrapped.aggregator.example.ClassExample;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/example-endpoint")
public class ExampleController {

    @GetMapping
    public ClassExample Test()
    {
        ClassExample shit = new ClassExample("fuck");
        return shit;
    }
}
