package pl.camp.it.library.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pl.camp.it.library.services.IBasketService;
import pl.camp.it.library.services.IBookService;
import pl.camp.it.library.session.SessionObject;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

@Controller
public class BasketController {

    @Autowired
    IBasketService basketService;

    @Resource
    SessionObject sessionObject;


    @RequestMapping(value = "/addToBasket/{bookId}", method = RequestMethod.GET)
    public String addToBasket(@PathVariable int bookId) {
        this.basketService.addBookToBasket(bookId);
        return "redirect:" + sessionObject.getLastAddress();
    }

    @RequestMapping(value = "/basket", method = RequestMethod.GET)
    public String showBasket(Model model) {
        model.addAttribute("basket", sessionObject.getBasket());
        model.addAttribute("isLogged", (sessionObject.getUser() != null));
        return "basket";
    }
}
