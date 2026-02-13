package com.jorge.library.Book;

import com.jorge.library.Author.AuthorModel;
import com.jorge.library.Author.AuthorRepository;
import org.springframework.stereotype.Component;

@Component
public class BookMapper {

    AuthorRepository authorRepository;

    public BookMapper(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    public BookDTO toDTO(BookModel book) {
        if (book == null) {
            return null;
        }

        BookDTO dto = new BookDTO();

        dto.setName(book.getName());
        dto.setId(book.getId());
        dto.setAuthor_id(book.getAuthor().getId());

        return dto;

    }

    public BookModel toEntity(BookDTO dto) {
        if (dto == null) {
            return null;
        }

        BookModel book = new BookModel();
        AuthorModel author = authorRepository.findById(dto.getAuthor_id())
                        .orElseThrow(() -> new IllegalArgumentException("Author not founded!"));

        book.setName(dto.getName());
        book.setId(dto.getId());
        book.setAuthor(author);

        return book;
    }

}
