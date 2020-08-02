package pl.camp.it.library.dao;

import pl.camp.it.library.model.User;

public interface IUserDAO {
    User getUserByLogin(String login);
    void addUser(User user);
}
