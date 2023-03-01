package fm.wrapped.musicgator.helper;

import fm.wrapped.musicgator.dto.UserAccountDTO;

public class InputValidator {

    public static boolean isUserAccountValidated(UserAccountDTO userAccountDTO) {
        if (userAccountDTO.getPassword() == null || userAccountDTO.getPassword().isEmpty() ||
                userAccountDTO.getUsername() == null || userAccountDTO.getUsername().isEmpty() ||
                userAccountDTO.getEmailAddress() == null || userAccountDTO.getEmailAddress().isEmpty() ||
                userAccountDTO.getBirthDate() == null || userAccountDTO.getBirthDate().isEmpty()) {
            return false;
        }

        return true;
    }

}
