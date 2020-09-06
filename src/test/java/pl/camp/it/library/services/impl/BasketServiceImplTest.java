package pl.camp.it.library.services.impl;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import pl.camp.it.library.AppConfigurationTest;
import pl.camp.it.library.dao.IAuthorDAO;
import pl.camp.it.library.dao.IBookDAO;
import pl.camp.it.library.dao.IUserDAO;
import pl.camp.it.library.model.Book;
import pl.camp.it.library.services.IBasketService;
import pl.camp.it.library.session.SessionObject;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {AppConfigurationTest.class})
@WebAppConfiguration
public class BasketServiceImplTest {

    @MockBean
    IUserDAO userDAO;

    @MockBean
    IAuthorDAO authorDAO;

    @MockBean
    IBookDAO bookDAO;

    @Autowired
    IBasketService basketService;

    @Autowired
    SessionObject sessionObject;

    @Before
    public void setUpMocks() {
        Book book = generateBook();

        Mockito.when(this.bookDAO.getBookById(5)).thenReturn(book);

    }

    @Test
    public void addingUniqueBookToBasketTest() {
        int bookId = 5;
        int expectedResult = 1;
        this.basketService.addBookToBasket(bookId);

        int result = this.sessionObject.getBasket().size();

        Assert.assertEquals(expectedResult, result);
    }


    @Test
    public void addingExistingBookToBasketTest() {
        int bookId = 5;
        int expectedBasketSize = 1;
        int expectedBookCount = 3;

        this.sessionObject.getBasket().put(generateBook(), 2);
        this.basketService.addBookToBasket(bookId);

        int result = this.sessionObject.getBasket().size();
        Assert.assertEquals(expectedBasketSize, result);

        int bookCount = this.sessionObject.getBasket().get(generateBook());
        Assert.assertEquals(expectedBookCount, bookCount);
    }

    private Book generateBook() {
        Book book = new Book();
        book.setId(5);
        book.setCategory(Book.Category.BAKING);
        book.setAuthor(null);
        book.setTitle("Testy jednostkowe");
        book.setIsbn("4532874329875");
        return book;
    }
}
