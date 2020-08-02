package pl.camp.it.library.model;

import javax.persistence.*;

@Entity(name = "tbook")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(nullable = false)
    private String title;
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Author author;
    @Column(nullable = false, unique = true, length = 20)
    private String isbn;

}
