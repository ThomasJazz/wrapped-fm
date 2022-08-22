package fm.wrapped.aggregator.dao;
import fm.wrapped.aggregator.entity.UserAccount;

public interface UserAccountDao {
    void insertUserAccount(UserAccount account);
    void updateUserAccount(UserAccount userAccount);
    void executeUpdateUserAccount(UserAccount userAccount);
}
