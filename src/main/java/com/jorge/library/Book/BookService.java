package com.jorge.library.Book;

import org.hibernate.annotations.NaturalId;
import org.hibernate.sql.model.ast.builder.CollectionRowDeleteByUpdateSetNullBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private BookMapper bookMapper;

    public BookService(BookRepository bookRepository, BookMapper bookMapper) {
        this.bookRepository = bookRepository;
        this.bookMapper = bookMapper;
    }


//    List all books
    public List<BookDTO> listBooks() {
        List<BookModel> books = bookRepository.findAll();
        return books.stream()
                .map(bookMapper::toDTO)
                .collect(Collectors.toList());
    }

//    Delete book
    public void deleteBook(Long id) {
        bookRepository.deleteById(id);
    }


//    Create book
    public BookDTO createBook(BookDTO bookDTO) {
        BookModel bookModel = bookMapper.toEntity(bookDTO);
        bookModel = bookRepository.save(bookModel);
        return bookMapper.toDTO(bookModel);
    }


}
