package fm.wrapped.aggregator.dao;

import fm.wrapped.aggregator.entity.UserAccount;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

@Repository
public class UserAccountDaoImpl implements UserAccountDao{

    NamedParameterJdbcTemplate template;

    public UserAccountDaoImpl(NamedParameterJdbcTemplate template) {
        this.template = template;
    }

    // Using a jdbc query template to insert a new record to the user_account db table
    @Override
    public void insertUserAccount(UserAccount user) {
        final String sql = "INSERT INTO userAccount(username, emailAddress, birthDate)" +
                " VALUES (:username, :emailAddress, :birthDate)";
        KeyHolder holder = new GeneratedKeyHolder();
        SqlParameterSource param = new MapSqlParameterSource()
                .addValue("username", user.getUsername())
                .addValue("emailAddress", user.getEmailAddress())
                .addValue("birthDate", user.getBirthDate());

        template.update(sql, param, holder);
    }

    @Override
    public void updateUserAccount(UserAccount userAccount) {

    }

    @Override
    public void executeUpdateUserAccount(UserAccount userAccount) {

    }
}
