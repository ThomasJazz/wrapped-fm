package fm.wrapped.aggregator.service;

import fm.wrapped.aggregator.entity.UserAccount;

public interface UserAccountService {
    void insertUserAccount(UserAccount user);
    void updateUserAccount(UserAccount user);
    void executeUpdateUserAccount(UserAccount userAccount);
}
