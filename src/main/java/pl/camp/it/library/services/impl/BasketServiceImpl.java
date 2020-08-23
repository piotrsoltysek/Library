package pl.camp.it.library.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.camp.it.library.dao.IBookDAO;
import pl.camp.it.library.model.Book;
import pl.camp.it.library.services.IBasketService;
import pl.camp.it.library.services.IBookService;
import pl.camp.it.library.session.SessionObject;

import javax.annotation.Resource;
import java.util.Map;

@Service
public class BasketServiceImpl implements IBasketService {

    @Autowired
    IBookDAO bookDAO;

    @Resource
    SessionObject sessionObject;

    @Override
    public void addBookToBasket(int id) {
        Book book = this.bookDAO.getBookById(id);
        Map<Book, Integer> basket = sessionObject.getBasket();
        boolean isBookInBasket = basket.containsKey(book);

        if (isBookInBasket) {
            basket.put(book, (basket.get(book)) + 1);
        } else {
            basket.put(book, 1);
        }

        System.out.println(basket);
    }
}
