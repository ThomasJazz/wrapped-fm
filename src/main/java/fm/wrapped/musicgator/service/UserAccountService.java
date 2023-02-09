package fm.wrapped.musicgator.service;

import fm.wrapped.musicgator.dto.UserAccountDTO;
import fm.wrapped.musicgator.entity.UserAccountEntity;

public interface UserAccountService {
    UserAccountDTO createUserAccount(UserAccountDTO user);
    UserAccountDTO updateUserAccount(UserAccountDTO user);
}
