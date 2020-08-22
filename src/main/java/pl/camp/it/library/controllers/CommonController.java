package pl.camp.it.library.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pl.camp.it.library.model.Book;
import pl.camp.it.library.services.IBookService;
import pl.camp.it.library.session.SessionObject;

import javax.annotation.Resource;
import java.util.List;

@Controller
public class CommonController {
    @Resource
    SessionObject sessionObject;

    @Autowired
    IBookService bookService;

    @RequestMapping(value = "/main", method = RequestMethod.GET)
    public String main(Model model) {
            model.addAttribute("isLogged", (sessionObject.getUser() != null));

        List<Book> books = bookService.getAllBooks();
        model.addAttribute("books", books);
        return "main";
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String defaultRedirect() {
        return "redirect:/main";
    }
}
