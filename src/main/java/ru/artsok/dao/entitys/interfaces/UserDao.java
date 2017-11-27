package ru.artsok.dao.entitys.interfaces;


import ru.artsok.dao.entitys.User;

public interface UserDao {
    public boolean appendNewUser(User user);
    public void deleteUserById(int id);
    public User selectUserByEmail(String email, String password);
}
