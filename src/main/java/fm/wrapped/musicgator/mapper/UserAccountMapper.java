package fm.wrapped.musicgator.mapper;

import fm.wrapped.musicgator.common.Constants;
import fm.wrapped.musicgator.dto.UserAccountDTO;
import fm.wrapped.musicgator.entity.UserAccountEntity;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Objects;
import java.util.Optional;
import java.util.UUID;

@Component
public class UserAccountMapper {
    DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern(Constants.DATE_FORMAT_YYYY_MM_DD);

    public void convertDtoToEntity(UserAccountDTO dto, UserAccountEntity entity) {
        if(StringUtils.isNotEmpty(dto.getId()))
            entity.setId(UUID.fromString(dto.getId().trim()));

        entity.setUsername(dto.getUsername());
        entity.setEmailAddress(dto.getEmailAddress());
        entity.setBirthDate(StringUtils.isEmpty(dto.getBirthDate()) ? null :
            LocalDateTime.parse(dto.getBirthDate(), dateFormatter));
        entity.setPassword(dto.getPassword());
    }

    public void convertEntityToDto(UserAccountDTO dto, UserAccountEntity entity) {
        if(!Objects.isNull(entity.getId()))
            dto.setId(entity.getId().toString());

        dto.setUsername(entity.getUsername());
        dto.setEmailAddress(entity.getEmailAddress());
        dto.setBirthDate(Objects.isNull(entity.getBirthDate()) ? null :
                entity.getBirthDate().toString());
        dto.setPassword(entity.getPassword());
    }
}
