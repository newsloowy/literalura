package me.sloowy.literalura.models;

import jakarta.persistence.*;
import me.sloowy.literalura.models.dto.AuthorDTO;
import me.sloowy.literalura.models.dto.BookDTO;

import java.util.List;
import java.util.stream.Collectors;

@Entity
@Table(name = "books")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    @ManyToOne
    private Author author;

    private String language;

    private Double downloadCount;

    public Book() {
    }

    public Book(BookDTO bookDTO) {
        this.title = bookDTO.title();
        this.language = bookDTO.languages().get(0);
        this.downloadCount = bookDTO.downloadCount();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public Double getDownloadCount() {
        return downloadCount;
    }

    public void setDownloadCount(Double downloadCount) {
        this.downloadCount = downloadCount;
    }

    @Override
    public String toString() {
        return  "------------------ LIVRO ------------------" +
                "\nTítulo:             " + title +
                "\nAutor:              " + author.getName() +
                "\nIdioma:             " + language +
                "\nNúmero de Download: " + downloadCount +
                "\n-------------------------------------------\n";
    }
}
