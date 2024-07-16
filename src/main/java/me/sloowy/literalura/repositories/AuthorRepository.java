package me.sloowy.literalura.repositories;

import me.sloowy.literalura.models.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AuthorRepository extends JpaRepository<Author, Long> {

    boolean existsByName(String name);

    Author findByName(String name);

    @Query("SELECT a FROM Author a WHERE a.deathYear >= :year AND :year >= a.birthYear")
    List<Author> listAuthorsLivingByYear(Integer year);

    @Query("SELECT a FROM Author a WHERE a.name ILIKE %:search%")
    List<Author> findAuthorsByName(String search);
}
