package me.sloowy.literalura.repositories;

import me.sloowy.literalura.models.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, Long> {

    boolean existsByTitle(String title);

    @Query("SELECT DISTINCT b.languages FROM Book b ORDER BY b.languages")
    List<String> listLanguage();

    @Query("SELECT b FROM Book b WHERE b.languages = :language")
    List<Book> findByLanguage(String language);
}
