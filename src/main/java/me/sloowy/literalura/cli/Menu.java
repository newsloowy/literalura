package me.sloowy.literalura.cli;

import com.fasterxml.jackson.core.JsonProcessingException;
import me.sloowy.literalura.models.Author;
import me.sloowy.literalura.models.Book;
import me.sloowy.literalura.models.dto.AuthorDTO;
import me.sloowy.literalura.models.dto.BookDTO;
import me.sloowy.literalura.repositories.AuthorRepository;
import me.sloowy.literalura.repositories.BookRepository;
import me.sloowy.literalura.services.ApiService;
import me.sloowy.literalura.services.DataConverter;

import java.util.List;
import java.util.Scanner;

public class Menu {

    private Scanner scanner = new Scanner(System.in);

    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;

    private ApiService apiService = new ApiService();
    private DataConverter dataConverter = new DataConverter();

    public Menu(BookRepository bookRepository, AuthorRepository authorRepository) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
    }

    public void startLiteralura() throws JsonProcessingException {
        String menu = """
                -------------------------------------------
                       *** Digite uma das opções ***
                -------------------------------------------
                1 - Buscar livros por título
                2 - Listar livros cadastrados
                3 - Listar autores cadastrados
                4 - Listar autores vivos em um determinado ano
                5 - Listar livros em determinado idioma
                
                0 - Sair
                -------------------------------------------
                """;

        int option = -1;
        while (option != 0) {
            System.out.println(menu);

            option = scanner.nextInt();
            scanner.nextLine();

            switch (option) {
                case 1:
                    newBook();
                    break;
                case 2:
                    listBooks();
                    break;
                case 3:
                    listAuthors();
                    break;
                case 4:
                    listAuthorsLivingByYear();
                    break;
                case 5:
                    listBooksByLanguage();
                    break;
            }
        }
    }
    private void newBook() {
        System.out.println("Digite o nome do livro que deseja inserir na base de dados:");
        var bookSearched = scanner.nextLine();

        String data = apiService.search(bookSearched);
        saveData(data);
    }

    private void listBooks() {
        List<Book> books = bookRepository.findAll();
        books.forEach(System.out::println);
    }

    private void listAuthors() {
        List<Author> authors = authorRepository.findAll();
        authors.forEach(System.out::println);
    }

    private void listAuthorsLivingByYear() {
        System.out.println("Qual ano deseja pesquisar:");
        int year = scanner.nextInt();
        scanner.nextLine();

        List<Author> authorsSearched = authorRepository.listAuthorsLivingByYear(year);
        if(!authorsSearched.isEmpty()){
            System.out.println("\nAtores vivos no ano de: " + year);
            authorsSearched.forEach(System.out::println);
        } else {
            System.out.println("Nenhum autor encontrado.");
        }
    }

    private void listBooksByLanguage() {
        var languages = bookRepository.listLanguage();
        System.out.println("Idiomas:");
        languages.forEach(System.out::println);

        System.out.println("Digite um dos idiomas:");
        var languageSelected = scanner.nextLine();
        bookRepository.findByLanguage(languageSelected).forEach(System.out::println);
    }

    private void saveData(String data) {
        try {
            BookDTO bookDTO = dataConverter.convertData(data, BookDTO.class);
            AuthorDTO authorDTO = dataConverter.convertData(data, AuthorDTO.class);

            Author author = new Author(authorDTO);
            if (!authorRepository.existsByName(author.getName())) {
                author = authorRepository.save(author);
            } else {
                author = authorRepository.findByName(author.getName());
            }

            Book book = new Book(bookDTO);
            book.setAuthor(author);
            if (!bookRepository.existsByTitle(book.getTitle())) {
                bookRepository.save(book);
            }
            System.out.println(book);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
