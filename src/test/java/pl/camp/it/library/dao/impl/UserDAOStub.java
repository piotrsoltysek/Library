package pl.camp.it.library.dao.impl;

import pl.camp.it.library.dao.IUserDAO;
import pl.camp.it.library.model.User;

public class UserDAOStub implements IUserDAO {

    @Override
    public User getUserByLogin(String login) {
        User user = new User();
        user.setId(4);
        user.setLogin("Mateusz");
        user.setPassword("trsnirrtrtwerreq");
        return user;
    }

    @Override
    public void addUser(User user) {

    }
}
