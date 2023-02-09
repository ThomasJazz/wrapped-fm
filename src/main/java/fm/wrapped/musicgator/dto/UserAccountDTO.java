package fm.wrapped.musicgator.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.Column;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.UUID;

@Getter
@Setter
public class UserAccountDTO {

    private String id;

    @JsonProperty("username")
    private String username;

    @JsonProperty("email_address")
    private String emailAddress;

    private String birthDate;
}
