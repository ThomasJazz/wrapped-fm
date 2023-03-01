package fm.wrapped.musicgator.controller;

// Imports from our project
import fm.wrapped.musicgator.dto.UserAccountDTO;

// 3rd party imports
import fm.wrapped.musicgator.service.UserAccountService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
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
    @Validated
    @PostMapping(path="/user")
    @Operation(summary = "Create a new user account", description = "test")
    public ResponseEntity<UserAccountDTO> createUserAccount(@RequestBody UserAccountDTO user) {
        ResponseEntity<UserAccountDTO> response = new ResponseEntity<>(userAccountService.createUserAccount(user),
                HttpStatus.CREATED);

        return response;
    }

    @PutMapping(path="/user/{userAccountId}")
    @ApiResponses(value = {@ApiResponse(responseCode = "201", description = "Service Request Created"),
            @ApiResponse(responseCode = "401", description = "Unauthorized"),
            @ApiResponse(responseCode = "403", description = "Forbidden"),
            @ApiResponse(responseCode = "404", description = "Resource Not Found"),
            @ApiResponse(responseCode = "500", description = "Custom runtime errors")})
    @Operation(summary = "blah", description = "test")
    public ResponseEntity<UserAccountDTO> updateUserAccount(@RequestBody UserAccountDTO user,
                                  @Parameter(name = "userAccountId", required = true)
                                  @PathVariable("userAccountId") String userAccountId) {
        ResponseEntity<UserAccountDTO> response = new ResponseEntity<>(
                userAccountService.updateUserAccount(user, userAccountId), HttpStatus.CREATED);

        return response;
    }

    @GetMapping(path="/user/{userAccountId}")
    public ResponseEntity<Boolean> checkPasswordMatch(
            @Parameter(name="password", required = true) String password,
            @Parameter(name = "userAccountId", required = true)
            @PathVariable("userAccountId") String userAccountId) {
        return null;
    }
}
