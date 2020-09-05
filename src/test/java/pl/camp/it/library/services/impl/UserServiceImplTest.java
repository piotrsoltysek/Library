package pl.camp.it.library.services.impl;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import pl.camp.it.library.AppConfigurationTest;
import pl.camp.it.library.dao.IUserDAO;
import pl.camp.it.library.model.User;
import pl.camp.it.library.services.IUserService;
import static org.mockito.ArgumentMatchers.anyString;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {AppConfigurationTest.class})
public class UserServiceImplTest {

    @Autowired
    IUserService userService;

    @Autowired
    IUserDAO userDAO;



    @Test//test do metody public boolean authenticate(User user)
    public void wrongPasswordAuthenticationTest() {
        Mockito.when(this.userDAO.getUserByLogin(anyString())).thenReturn(generateUser1());
        User user = new User();
        user.setLogin("mateusz");
        user.setPassword("freufhiurewfoiuw");

        boolean result = userService.authenticate(user);

        Assert.assertFalse(result);

    }

    @Test
    public void correctAuthenticationTest() {
        Mockito.when(this.userDAO.getUserByLogin(anyString())).thenReturn(generateUser2());
        User user = new User();
        user.setLogin("admin");
        user.setPassword("admin");

        boolean result = userService.authenticate(user);

        Assert.assertTrue(result);
    }


    private User generateUser1() {
        User user = new User();
        user.setLogin("mateusz");
        user.setPassword("viufewqf");
        user.setId(5);

        return user;
    }

    private User generateUser2() {
        User user = new User();
        user.setLogin("mateusz");
        user.setPassword("21232f297a57a5a743894a0e4a801fc3");
        user.setId(5);

        return user;
    }

}
