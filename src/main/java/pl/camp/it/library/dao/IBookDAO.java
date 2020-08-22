package pl.camp.it.library.dao;

import pl.camp.it.library.model.Book;

import java.util.List;

public interface IBookDAO {
    void addBook(Book book);
    List<Book> getAllBooks();
}
