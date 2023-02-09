package fm.wrapped.musicgator.controller;

// Imports from our project
import fm.wrapped.musicgator.dto.UserAccountDTO;

// 3rd party imports
import fm.wrapped.musicgator.service.UserAccountService;
// import org.springframework.beans.factory.annotation.Value;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path="/music-gator/api/v1")
public class UserAccountController {
    @Autowired
    UserAccountService userAccountService;

    // TODO: Have this return the created userAccountID
    @ApiResponses(value = {@ApiResponse(responseCode = "201", description = "Service Request Created"),
            @ApiResponse(responseCode = "401", description = "Unauthorized"),
            @ApiResponse(responseCode = "403", description = "Forbidden"),
            @ApiResponse(responseCode = "404", description = "Resource Not Found"),
            @ApiResponse(responseCode = "500", description = "Custom runtime errors")})
    @PostMapping(path="/user")
    @Operation(summary = "blah", description = "test")
    public void createUserAccount(@RequestBody UserAccountDTO user)
    {
        userAccountService.createUserAccount(user);
    }

    @PutMapping("/update")
    @Operation(summary = "blah", description = "test")
    public void updateUserAccount(@RequestBody UserAccountDTO user)
    {
        userAccountService.updateUserAccount(user);
    }
}
