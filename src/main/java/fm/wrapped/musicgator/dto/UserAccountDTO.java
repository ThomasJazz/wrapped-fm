package fm.wrapped.musicgator.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserAccountDTO {
    @JsonProperty("id")
    private String id;

    @JsonProperty("username")
    private String username;

    @JsonProperty("emailAddress")
    private String emailAddress;

    @JsonProperty("birthDate")
    private String birthDate;

    @JsonProperty("password")
    private String password;

}
