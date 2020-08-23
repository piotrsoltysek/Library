package pl.camp.it.library.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.camp.it.library.dao.IAuthorDAO;
import pl.camp.it.library.dao.IBookDAO;
import pl.camp.it.library.model.Author;
import pl.camp.it.library.model.Book;
import pl.camp.it.library.services.IBookService;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class BookServiceImpl implements IBookService {
    @Autowired
    IBookDAO bookDAO;

    @Autowired
    IAuthorDAO authorDAO;

    @Override
    public void addBook(Book book) {
        this.bookDAO.addBook(book);
    }

    @Override
    public List<Book> getAllBooks() {
        return this.bookDAO.getAllBooks();
    }

    @Override
    public List<Book> findBooks(String pattern) {
        Set<Book> result = new HashSet<Book>();
        List<Book> books = this.bookDAO.findBooks(pattern);

        result.addAll(books);

        List<Author> authors = this.authorDAO.findAuthors(pattern);
        for (Author author : authors) {
            List<Book> booksForAuthor = this.bookDAO.getBooksByAuthorId(author.getId());

            result.addAll(booksForAuthor);
        }
        return new ArrayList<>(result);
    }

    @Override
    public List<Book> getBooksByCategory(Book.Category category) {
        return this.bookDAO.getBooksByCategory(category);
    }
}
