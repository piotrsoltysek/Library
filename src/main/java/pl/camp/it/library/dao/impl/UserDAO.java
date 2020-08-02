package pl.camp.it.library.dao.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import pl.camp.it.library.dao.IUserDAO;
import pl.camp.it.library.model.User;

import javax.persistence.NoResultException;
import java.util.concurrent.ExecutionException;


@Repository
public class UserDAO implements IUserDAO {

    @Autowired
    SessionFactory sessionFactory;



    @Override
    public User getUserByLogin(String login) {
        try {
            Session session = sessionFactory.openSession();
            Query<User> query = session.createQuery("FROM pl.camp.it.library.model.User WHERE login = :login");
            query.setParameter("login", login);

            User user = query.getSingleResult();
            session.close();
            return user;
        } catch (NoResultException e) {
            return null;
        }

    }

    @Override
    public void addUser(User user) {
        Session session = sessionFactory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.save(user);
            tx.commit();
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
        } finally {
            session.close();
        }
    }
}
