package pl.camp.it.library.dao.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import pl.camp.it.library.dao.IAuthorDAO;
import pl.camp.it.library.model.Author;
import pl.camp.it.library.model.Book;

import java.util.List;

@Repository
public class AuthorDAOImpl implements IAuthorDAO {

    @Autowired
    SessionFactory sessionFactory;

    @Override
    public List<Author> findAuthors(String pattern) {
        Session session = this.sessionFactory.openSession();
        Query<Author> query = session.createQuery("FROM pl.camp.it.library.model.Author WHERE name LIKE :name OR surname LIKE :surname");
        query.setParameter("name", "%" + pattern + "%");
        query.setParameter("surname", "%" + pattern + "%");

        List<Author> result = query.getResultList();
        session.close();
        return result;
    }
}
