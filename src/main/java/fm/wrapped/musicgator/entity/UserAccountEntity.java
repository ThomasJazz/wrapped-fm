package fm.wrapped.musicgator.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.jpa.convert.threeten.Jsr310JpaConverters;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Builder
@Table(name = "user_account")
@Getter
@Setter
@RequiredArgsConstructor
@AllArgsConstructor
public class UserAccountEntity {

    @Id
    @JsonProperty
    @GeneratedValue(generator = "UUID")
    @Column(name="id")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    private UUID id;

    @JsonProperty
    @Column(name = "username")
    private String username;

    @Column(name = "email_address")
    @JsonProperty
    private String emailAddress;

    @JsonProperty
    @Convert(converter = Jsr310JpaConverters.LocalDateTimeConverter.class)
    @Column(name="birth_date")
    private LocalDateTime birthDate;

    @JsonInclude
    @Column(name="password")
    private String password;

    @UpdateTimestamp
    @Convert(converter = Jsr310JpaConverters.LocalDateTimeConverter.class)
    @Column(name = "modified_date")
    private LocalDateTime modifiedDate;

    @JsonProperty
    @Column(name="create_date")
    @CreationTimestamp
    private LocalDateTime createDate;
}
