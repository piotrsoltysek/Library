package pl.camp.it.library;

import org.mockito.Mockito;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.annotation.SessionScope;
import pl.camp.it.library.dao.IAuthorDAO;
import pl.camp.it.library.dao.IBookDAO;
import pl.camp.it.library.dao.IUserDAO;
import pl.camp.it.library.session.SessionObject;

@Configuration
@ComponentScan(basePackages = {"pl.camp.it.library.controllers", "pl.camp.it.library.services"})
public class AppConfigurationTest {

/*  @Bean
    public IUserDAO userDAO() {
        return new UserDAOStub();
    }

    @Bean
    public IBookDAO bookDAO() {
        return new BookDAOStub();
    }

    @Bean
    public IAuthorDAO authorDAO() {
        return new AuthorDAOStub();
    }

    @Bean
    @SessionScope
    public SessionObject sessionObject() {
        return new SessionObject();
    }
    */

    @Bean
    public IUserDAO userDAO() {
        return Mockito.mock(IUserDAO.class);
    }

    @Bean
    public IBookDAO bookDAO() {
        return Mockito.mock(IBookDAO.class);
    }

    @Bean
    public IAuthorDAO authorDAO() {
        return Mockito.mock(IAuthorDAO.class);
    }

    @Bean
    @SessionScope
    public SessionObject sessionObject() {
        return new SessionObject();
    }


}
