package com.jorge.library.Book;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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

}
