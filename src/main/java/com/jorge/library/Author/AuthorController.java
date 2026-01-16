package com.jorge.library.Author;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.PrivateKey;
import java.util.List;

@RestController
@RequestMapping("author")
public class AuthorController {

    private AuthorService authorService;

    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }

    //    Endpoints

//    Test Endpoint
    @GetMapping("test")
    public String authorTest() {return "Working!!";}

//    Get all authors
    @GetMapping("listAuthors")
    public List<AuthorDTO> listAuthors() {
        return authorService.listAuthors();
    }

//    Delete author
    @DeleteMapping("deleteAuthor/{id}")
    public ResponseEntity<String> deleteAuthor(@PathVariable Long id) {
        authorService.deleteAuthor(id);
        return ResponseEntity.ok("Author deleted successfullya");
    }

}
