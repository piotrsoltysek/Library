package pl.camp.it.library.controllers;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pl.camp.it.library.model.Author;
import pl.camp.it.library.model.Book;
import pl.camp.it.library.model.User;
import pl.camp.it.library.services.IBookService;
import pl.camp.it.library.services.IUserService;

@Controller
@RequestMapping(value = "/admin/utils")
public class AdminController {
    @Autowired
    IBookService bookService;

    @Autowired
    IUserService userService;

    @RequestMapping(value = "/addUser", method = RequestMethod.GET)
    public String addUser() {
        User user = new User();
        user.setLogin("admin");
        String hashedPassword = DigestUtils.md5Hex("admin");
        user.setPassword(hashedPassword);
        userService.addUser(user);
        return "redirect:/login";
    }

    @RequestMapping(value = "/addBooks", method = RequestMethod.GET)
    public String addBooks() {
        Book book1 = new Book();
        book1.setIsbn("978-83-8168-518-4");
        book1.setTitle("Kod otyłości");

        Author author1 = new Author();
        author1.setName("Jason");
        author1.setSurname("Fung");
        book1.setAuthor(author1);

        Book book2 = new Book();
        book2.setIsbn("978-83-8151-243-5");
        book2.setTitle("Domowe kiszonki które leczą");

        Author author2 = new Author();
        author2.setName("Magdalena");
        author2.setSurname("Jarzynka-Jendrzejewska");
        book2.setAuthor(author2);

        Book book3 = new Book();
        book3.setIsbn("978-83-8151-000-5");
        book3.setTitle("Pieczywo domowe");

        Author author3 = new Author();
        author3.setName("Elżbieta");
        author3.setSurname("Kiewnarska ");
        book3.setAuthor(author3);

        Book book4 = new Book();
        book4.setIsbn("978-83-8151-151-3");
        book4.setTitle("Pieczenie");

        book4.setAuthor(author2);


        Book book5 = new Book();
        book5.setIsbn("000-83-8168-518-4");
        book5.setTitle("Ciasta wielkanocne");

        Author author5 = new Author();
        author5.setName("Siostra");
        author5.setSurname("Anastazja");
        book5.setAuthor(author5);



        this.bookService.addBook(book1);
        this.bookService.addBook(book2);
        this.bookService.addBook(book3);
        this.bookService.addBook(book4);
        this.bookService.addBook(book5);

        return "redirect:/main";


    }

}
