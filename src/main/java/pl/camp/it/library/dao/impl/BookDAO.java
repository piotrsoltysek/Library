package pl.camp.it.library.dao.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import pl.camp.it.library.dao.IBookDAO;
import pl.camp.it.library.model.Book;

import java.util.List;

@Repository
public class BookDAO implements IBookDAO {
    @Autowired
    SessionFactory sessionFactory;

    @Override
    public void addBook(Book book) {
        Session session = sessionFactory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.save(book);
            tx.commit();
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
        } finally {
            session.close();
        }
    }

    @Override
    public List<Book> getAllBooks() {
        Session session = this.sessionFactory.openSession();
        Query<Book> query = session.createQuery("FROM pl.camp.it.library.model.Book");

        List<Book> result = query.getResultList();
        session.close();
        return result;
    }
}
