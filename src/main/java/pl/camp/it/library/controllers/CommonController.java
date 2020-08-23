package pl.camp.it.library.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
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

        List<Book> books = this.bookService.getAllBooks();
        model.addAttribute("books", books);
        this.sessionObject.setLastAddress("/main");
        return "main";
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String defaultRedirect() {
        return "redirect:/main";
    }

    @RequestMapping(value = "/find", method = RequestMethod.POST)
    public String findBooks(Model model, @RequestParam String pattern) {
        model.addAttribute("isLogged", (sessionObject.getUser() != null));
        List<Book> books = this.bookService.findBooks(pattern);
        this.sessionObject.setLastFindPattern(pattern);
        model.addAttribute("books", books);
        this.sessionObject.setLastAddress("/find");
        return "main";
    }

    @RequestMapping(value = "/find", method = RequestMethod.GET)
    public String findBooks(Model model) {
        model.addAttribute("isLogged", (sessionObject.getUser() != null));
        List<Book> books = this.bookService.findBooks(sessionObject.getLastFindPattern());
        model.addAttribute("books", books);
        this.sessionObject.setLastAddress("/find");
        return "main";
    }


    @RequestMapping(value = "/cooking", method = RequestMethod.GET)
    public String cookingBooks(Model model) {
        model.addAttribute("isLogged", (sessionObject.getUser() != null));
        List<Book> books = this.bookService.getBooksByCategory(Book.Category.COOKING);
        model.addAttribute("books", books);
        this.sessionObject.setLastAddress("/cooking");
        return "main";
    }

    @RequestMapping(value = "/baking", method = RequestMethod.GET)
    public String bakingBooks(Model model) {
        model.addAttribute("isLogged", (sessionObject.getUser() != null));
        List<Book> books = this.bookService.getBooksByCategory(Book.Category.BAKING);
        model.addAttribute("books", books);
        this.sessionObject.setLastAddress("/baking");
        return "main";
    }
}
