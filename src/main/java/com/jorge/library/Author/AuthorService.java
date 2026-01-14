package com.jorge.library.Author;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
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
    public List<AuthorDTO> listAuthors(){
        List<AuthorModel> author = authorRepository.findAll();
        return author.stream()
                .map(authorMapper::toDTO)
                .collect(Collectors.toList());
    }
}
