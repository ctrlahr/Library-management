package com.jorge.library.Author;
import jakarta.persistence.Table;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
public class AuthorService {

    @Autowired
    private AuthorRepository authorRepository;

    @Autowired
    private AuthorMapper authorMapper;

    public AuthorService(AuthorRepository authorRepository, AuthorMapper authorMapper) {
        this.authorRepository = authorRepository;
        this.authorMapper = authorMapper;
    }

//    Métodos

//    List authors
    public List<AuthorDTO> listAuthors(){
        List<AuthorModel> author = authorRepository.findAll();
        return author.stream()
                .map(authorMapper::toDTO)
                .collect(Collectors.toList());
    }

//    List author by id
    public AuthorDTO listAuthorById(Long id) {
        Optional<AuthorModel> author = authorRepository.findById(id);
        return author.stream()
                .map(authorMapper::toDTO)
                .findFirst()
                .orElse(null);
    }

//    Delete author
    public void deleteAuthor(Long id) {
        authorRepository.deleteById(id);
    }
}
