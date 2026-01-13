package com.jorge.library.Book;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("books")
public class BookController {

//    Endpoints

//    Test Endpoint
    @GetMapping("test")
    public String register() {
        return "Working!!";
    }

//    ShowAll books endpoint
    

}
