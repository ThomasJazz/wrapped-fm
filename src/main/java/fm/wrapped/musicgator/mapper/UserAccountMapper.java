package fm.wrapped.musicgator.mapper;

import fm.wrapped.musicgator.common.Constants;
import fm.wrapped.musicgator.dto.UserAccountDTO;
import fm.wrapped.musicgator.entity.UserAccountEntity;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Objects;
import java.util.UUID;

@Component
public class UserAccountMapper {
    DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern(Constants.DATE_FORMAT_YYYY_MM_DD);

//    public void convertBodyDtoToEntity(UserAccountBodyDTO dto, UserAccountEntity entity) {
//        entity.setUserId(UUID.fromString(dto.getId()));
//        entity.setUsername(dto.getUsername());
//        entity.setEmailAddress(dto.getEmailAddress());
//        entity.setBirthDate(Objects.isNull(dto.getBirthDate()) ? null
//                : LocalDate.parse(dto.getBirthDate(), dateFormatter));
//    }

    public void convertDtoToEntity(UserAccountDTO dto, UserAccountEntity entity) {
        entity.setUserId(UUID.fromString(dto.getId()));
        entity.setUsername(dto.getUsername());
        entity.setEmailAddress(dto.getEmailAddress());
        entity.setBirthDate(Objects.isNull(dto.getBirthDate()) ? null
                : LocalDate.parse(dto.getBirthDate(), dateFormatter));
    }
}
