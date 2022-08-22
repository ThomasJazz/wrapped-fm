package fm.wrapped.aggregator.controller;

// Imports from our project
import fm.wrapped.aggregator.entity.*;

// 3rd party imports
import fm.wrapped.aggregator.service.UserAccountService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/internal/user")
public class UserController {
    @Resource
    UserAccountService userAccountService;

    // TODO: Have this return the created userAccountID
    @PostMapping("/add")
    public void addUserAccount(@RequestBody UserAccount user)
    {
        userAccountService.insertUserAccount(user);
    }

    @PutMapping("/update")
    public void updateUserAccount(@RequestBody UserAccount user)
    {
        userAccountService.updateUserAccount(user);
    }
}
