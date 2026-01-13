package com.jorge.library.Author;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("author")
public class AuthorController {

//    Endpoints

//    Test Endpoint
    @GetMapping("test")
    public String authorTest() {return "Working!!";}

//    Get all authors


}
