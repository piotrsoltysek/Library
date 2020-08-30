package pl.camp.it.library.services.impl;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import pl.camp.it.library.AppConfiguration;
import pl.camp.it.library.model.User;
import pl.camp.it.library.services.IUserService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {AppConfiguration.class})
public class UserServiceImplTest {

    @Autowired
    IUserService userService;



    @Test//test do metody public boolean authenticate(User user)
    public void wrongPasswordAuthenticationTest() {
        User user = new User();
        user.setLogin("testUser");
        user.setPassword("testPassword");

        boolean result = userService.authenticate(user);

        Assert.assertFalse(result);

    }
}
