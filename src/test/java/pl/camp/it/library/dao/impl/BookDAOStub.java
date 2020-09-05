package pl.camp.it.library.dao.impl;

import pl.camp.it.library.dao.IBookDAO;
import pl.camp.it.library.model.Book;

import java.util.List;

public class BookDAOStub implements IBookDAO {
    @Override
    public void addBook(Book book) {

    }

    @Override
    public List<Book> getAllBooks() {
        return null;
    }

    @Override
    public List<Book> findBooks(String pattern) {
        return null;
    }

    @Override
    public List<Book> getBooksByAuthorId(int id) {
        return null;
    }

    @Override
    public List<Book> getBooksByCategory(Book.Category category) {
        return null;
    }

    @Override
    public Book getBookById(int id) {
        return null;
    }
}
