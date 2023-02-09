package fm.wrapped.musicgator.service;

import fm.wrapped.musicgator.dto.UserAccountDTO;
import fm.wrapped.musicgator.entity.UserAccountEntity;
import fm.wrapped.musicgator.mapper.UserAccountMapper;
import fm.wrapped.musicgator.repository.UserAccountRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Slf4j
@Service
public class UserAccountServiceImpl implements UserAccountService {
    @Autowired
    private UserAccountRepository userAccountRepository;

    @Autowired
    UserAccountMapper userAccountMapper;

    @Override
    public UserAccountDTO createUserAccount(UserAccountDTO userAccountDTO) {
        UserAccountEntity userAccountEntity = new UserAccountEntity();

        userAccountMapper.convertDtoToEntity(userAccountDTO, userAccountEntity);
        userAccountEntity = userAccountRepository.save(userAccountEntity);

        userAccountMapper.convertEntityToDto(userAccountDTO, userAccountEntity);
        return userAccountDTO;
    }

    @Override
    public UserAccountDTO updateUserAccount(UserAccountDTO userAccountDTO, String userId) {
        UserAccountEntity userAccountEntity = userAccountRepository.findById(UUID.fromString(userId)).orElseThrow();
        userAccountDTO.setId(userId);

        userAccountMapper.convertDtoToEntity(userAccountDTO, userAccountEntity);
        userAccountEntity = userAccountRepository.save(userAccountEntity);

        userAccountMapper.convertEntityToDto(userAccountDTO, userAccountEntity);
        return userAccountDTO;
    }


}
