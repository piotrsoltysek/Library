package pl.camp.it.library.session;

import pl.camp.it.library.model.Book;
import pl.camp.it.library.model.User;

import java.util.HashMap;
import java.util.Map;

public class SessionObject {
    private User user;
    private String lastAddress;
    private Map<Book, Integer> basket = new HashMap<>();
    private String lastFindPattern;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getLastAddress() {
        return lastAddress;
    }

    public void setLastAddress(String lastAddress) {
        this.lastAddress = lastAddress;
    }

    public Map<Book, Integer> getBasket() {
        return basket;
    }

    public void setBasket(Map<Book, Integer> basket) {
        this.basket = basket;
    }

    public String getLastFindPattern() {
        return lastFindPattern;
    }

    public void setLastFindPattern(String lastFindPattern) {
        this.lastFindPattern = lastFindPattern;
    }
}
