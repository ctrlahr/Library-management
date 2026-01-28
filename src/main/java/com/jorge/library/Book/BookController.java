package com.jorge.library.Book;

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
            return ResponseEntity.badRequest()
                    .body("An ID is required to delete a book!");
        }
        bookService.deleteBook(id);
        return ResponseEntity.ok()
                .body("Book deleted!");
    }

//    Create book
    @PostMapping("create")
    public BookDTO createBook(@RequestBody BookDTO bookDTO) {
        if (bookDTO == null) {
            System.out.println("The book has not created, something went wrong!!");
            return null;
        }
        System.out.println("Book created!!");
        return bookService.createBook(bookDTO);
    }

}
