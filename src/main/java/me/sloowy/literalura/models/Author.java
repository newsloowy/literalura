package me.sloowy.literalura.models;

import jakarta.persistence.*;
import me.sloowy.literalura.models.dto.AuthorDTO;

import java.util.List;
import java.util.stream.Collectors;

@Entity
@Table(name = "authors")
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String name;

    private int birthYear;

    private int deathYear;

    @OneToMany(mappedBy = "author", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Book> books;

    public Author() {
    }

    public Author(AuthorDTO authorDTO) {
        this.name = authorDTO.name();
        this.birthYear = authorDTO.birthYear();
        this.deathYear = authorDTO.deathYear();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getBirthYear() {
        return birthYear;
    }

    public void setBirthYear(int birthYear) {
        this.birthYear = birthYear;
    }

    public int getDeathYear() {
        return deathYear;
    }

    public void setDeathYear(int deathYear) {
        this.deathYear = deathYear;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    @Override
    public String toString() {
        return  "------------------- Autor -------------------" +
                "\nAutor:           " + name +
                "\nAno Nascimento:  " + birthYear +
                "\nAno Falecimento: " + deathYear +
                "\nLivros:          " + books.stream().map(b -> b.getTitle()).collect(Collectors.toList()) +
                "\n-------------------------------------------\n";
    }
}
