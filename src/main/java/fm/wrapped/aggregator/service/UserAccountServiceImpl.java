package fm.wrapped.aggregator.service;

import fm.wrapped.aggregator.entity.UserAccount;
import fm.wrapped.aggregator.dao.UserAccountDao;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
public class UserAccountServiceImpl implements UserAccountService {
    @Resource
    UserAccountDao userAccountDao;

    @Override
    public void insertUserAccount(UserAccount user) {
        userAccountDao.insertUserAccount(user);
    }

    @Override
    public void updateUserAccount(UserAccount user) {
        userAccountDao.updateUserAccount(user);
    }

    @Override
    public void executeUpdateUserAccount(UserAccount user) {
        userAccountDao.executeUpdateUserAccount(user);
    }
}
