package fm.wrapped.musicgator.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.jpa.convert.threeten.Jsr310JpaConverters;

import javax.persistence.*;
import java.time.LocalDate;
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
    private UUID userId;

    @JsonProperty
    @Column(name = "username")
    private String username;

    @Column(name = "email_address")
    @JsonProperty
    private String emailAddress;

    @JsonProperty
    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd", timezone="PST")
    @Column(name="birth_date")
    private LocalDate birthDate;

    @UpdateTimestamp
    @Convert(converter = Jsr310JpaConverters.LocalDateTimeConverter.class)
    @Column(name = "modified_date")
    private LocalDateTime modifiedDate;

    @JsonProperty
    @Column(name="create_date")
    @CreationTimestamp
    private LocalDateTime createDate;
}
