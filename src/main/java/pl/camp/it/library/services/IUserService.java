package pl.camp.it.library.services;

import pl.camp.it.library.model.User;

public interface IUserService {
    boolean authenticate(User user);
    void addUser(User user);
}
