package pl.camp.it.library.services.impl;

import org.apache.commons.codec.digest.DigestUtils;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import pl.camp.it.library.AppConfigurationTest;
import pl.camp.it.library.dao.IAuthorDAO;
import pl.camp.it.library.dao.IBookDAO;
import pl.camp.it.library.dao.IUserDAO;
import pl.camp.it.library.model.User;
import pl.camp.it.library.services.IUserService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {AppConfigurationTest.class})
public class UserServiceImplTest {

    @Autowired
    IUserService userService;

    @MockBean
    IUserDAO userDAO;

    @MockBean
    IAuthorDAO authorDAO;

    @MockBean
    IBookDAO bookDAO;

    @Before
    public void setUpMocks() {
        User user = new User();
        user.setId(5);
        user.setLogin("mateusz");
        user.setPassword(DigestUtils.md5Hex("haslo"));

        Mockito.when(this.userDAO.getUserByLogin("mateusz")).thenReturn(user);


        user = new User();
        user.setId(5);
        user.setLogin("admin");
        user.setPassword(DigestUtils.md5Hex("admin"));

        Mockito.when(this.userDAO.getUserByLogin("admin")).thenReturn(user);


        Mockito.when(userDAO.getUserByLogin("badLogin")).thenReturn(null);

    }





    @Test//test do metody public boolean authenticate(User user)
    public void wrongPasswordAuthenticationTest() {
        /*Mockito.when(this.userDAO.getUserByLogin(anyString())).thenReturn(generateUser("mateusz", "fewbyuewb", 5));*/
        User user = new User();
        user.setLogin("mateusz");
        user.setPassword("sadfunaiufniua");

        boolean result = userService.authenticate(user);

        Assert.assertFalse(result);

    }

    @Test
    public void correctAuthenticationTest() {
        /*Mockito.when(this.userDAO.getUserByLogin(anyString())).thenReturn(generateUserAndHashPassword("admin", "admin", 5));*/
        User user = new User();
        user.setLogin("admin");
        user.setPassword("admin");

        boolean result = userService.authenticate(user);

        Assert.assertTrue(result);
    }

    @Test
    public void wrongLoginAuthenticationTest() {
        User user = new User();
        user.setLogin("badLogin");
        user.setPassword("admin");

        boolean result = userService.authenticate(user);

        Assert.assertFalse(result);
    }

    @Test
    public void wrongRepeatedPasswordDuringRegistrationTest() {
        User user = new User();
        user.setLogin("janusz");
        user.setPassword("janusz");
        String repeatedPassword = "janusz2";


        boolean result = userService.registerUser(user, repeatedPassword);

        Assert.assertFalse(result);
    }


    @Test
    public void correctRepeatedPasswordDuringRegistrationTest() {
        User user = new User();
        user.setLogin("janusz");
        user.setPassword("janusz");
        String repeatedPassword = "janusz";


        boolean result = userService.registerUser(user, repeatedPassword);

        Assert.assertTrue(result);

    }















/*
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

    private User generateUser(String login, String hashPass, int id) {
        User user = new User();
        user.setLogin(login);
        user.setPassword(hashPass);
        user.setId(id);

        return user;
    }

    private User generateUserAndHashPassword(String login, String pass, int id) {
        User user = new User();
        user.setLogin(login);
        user.setPassword(DigestUtils.md5Hex(pass));
        user.setId(id);

        return user;
    }
*/

}
