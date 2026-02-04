package com.jorge.library.Book;

import org.springframework.data.repository.config.RepositoryNameSpaceHandler;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("book")
public class BookController {

    private BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }


    //    Test Endpoint
    @GetMapping("test")
    public String bookTest() {
        return "Working!!";
    }


//    List all books
    @GetMapping("listAll")
    public List<BookDTO> listBooks() {
        return bookService.listBooks();
    }

//    Delete book
    @DeleteMapping("delete/{id}")
    public ResponseEntity<String> deleteBook(@PathVariable Long id) {
        if (id == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("An ID is required to delete a book!");
        }
        bookService.deleteBook(id);
        return ResponseEntity.status(HttpStatus.OK).body("Book deleted!");
    }

//    Create book
    @PostMapping("create")
    public ResponseEntity<String> createBook(@RequestBody BookDTO bookDTO) {
        if (bookDTO == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("The book has not created, something went wrong!!");
        }
        System.out.println("Book created!!");
        bookService.createBook(bookDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body("Book created!");
    }

//    Update book
    @PutMapping("update/{id}")
    public ResponseEntity<String> updateBook(@PathVariable Long id, @RequestBody BookDTO bookDTO) {
        if (id == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Author doesn't exists");
        }
        else if (bookDTO == null) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body("The request needs a body");
        }
        BookDTO book_created = bookService.updateBook(id, bookDTO);
        return ResponseEntity.status(HttpStatus.OK).body("Book " + book_created.getName() + " updated!");

    }

}
