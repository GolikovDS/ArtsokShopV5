package ru.artsok.dao.implementes;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import ru.artsok.dao.entitys.User;
import ru.artsok.dao.entitys.interfaces.UserDao;

@Repository
public class UserDaoImpl implements UserDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;


    public UserDaoImpl() {
    }

    @Override
    public boolean appendNewUser(User user) {
        try {
            jdbcTemplate.update("INSERT INTO public.users (first_name, last_name, phone, username, company, middle_name, password, enabled) " +
                            "VALUES (?, ?, ?, ?, ?, ?, ?, ?)", user.getFirstName(), user.getLastName(), user.getPhone(),
                    user.getUsername(), user.getCompany(), user.getMiddleName(), user.getPassword(), 1);
            return true;
        } catch (DuplicateKeyException e) {
            return false;
        }
    }

    @Override
    public void deleteUserById(int id) {

    }

    @Override
    public User selectUserByEmail(String email, String password) {
        return null;
    }
}
