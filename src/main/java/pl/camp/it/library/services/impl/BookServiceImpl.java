package pl.camp.it.library.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.camp.it.library.dao.IBookDAO;
import pl.camp.it.library.model.Book;
import pl.camp.it.library.services.IBookService;

import java.util.List;

@Service
public class BookServiceImpl implements IBookService {
    @Autowired
    IBookDAO bookDAO;

    @Override
    public void addBook(Book book) {
        this.bookDAO.addBook(book);
    }

    @Override
    public List<Book> getAllBooks() {
        return this.bookDAO.getAllBooks();
    }
}
