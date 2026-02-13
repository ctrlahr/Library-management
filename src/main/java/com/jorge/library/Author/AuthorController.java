package com.jorge.library.Author;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("author")
public class AuthorController {

    private final AuthorService authorService;

    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }

    //    Endpoints

//    Test Endpoint
    @GetMapping("test")
    public String authorTest() {return "Working!!";}

//    Get all authors
    @GetMapping("listAll")
    public List<AuthorDTO> listAuthors() {
        return authorService.listAuthors();
    }

//    Delete author
    @DeleteMapping("delete/{id}")
    public ResponseEntity<String> deleteAuthor(@PathVariable Long id) {
        AuthorDTO author = authorService.listAuthorById(id);
        if (author == null) {
            return ResponseEntity.badRequest()
                    .body("This author dont exist!");
        }
        else {
            authorService.deleteAuthor(id);
            return ResponseEntity.ok()
                    .body("Author " + author.getName() + " deleted successfully!");
        }
    }

//    Create author
    @PostMapping("create")
    public ResponseEntity<String> createAuthor(@RequestBody AuthorDTO author) {
        AuthorDTO authorCreated = authorService.createAuthor(author);

        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Author " + authorCreated + " created!!");
        }


//     Update author
    @PutMapping("update/{id}")
    public ResponseEntity<String> updateAuthor(@PathVariable Long id, @RequestBody AuthorDTO authorDTO) {
        authorService.updateAuthor(id, authorDTO);

        if (id == null) {
            return ResponseEntity.badRequest()
                    .body("Author not founded!");
        }
        else {
            return ResponseEntity.ok()
                    .body("Author " + authorDTO.getName() + " updated!!");
        }
    }

}
