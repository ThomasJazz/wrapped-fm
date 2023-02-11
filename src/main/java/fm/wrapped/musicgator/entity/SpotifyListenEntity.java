package fm.wrapped.musicgator.entity;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.jpa.convert.threeten.Jsr310JpaConverters;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.UUID;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "spotify_listen")
public class SpotifyListenEntity {
    @Id
    @JsonProperty
    @GeneratedValue(generator = "UUID")
    @Column(name="id")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    public UUID spotifyListenId;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_account_id")
    @ToString.Exclude
    @JsonBackReference
    public UserAccountEntity userAccountId;

    @UpdateTimestamp
    @Convert(converter = Jsr310JpaConverters.LocalDateTimeConverter.class)
    @Column(name = "modified_date")
    private LocalDateTime modifiedDate;

    @JsonProperty
    @Column(name="create_date")
    @CreationTimestamp
    private LocalDateTime createDate;

}
