package com.jorge.library.Book;

import org.springframework.stereotype.Component;

@Component
public class BookMapper {

    public BookDTO toDTO(BookModel book) {
        if (book == null) {
            return null;
        }

        BookDTO dto = new BookDTO();

        dto.setName(book.getName());
        dto.setId(book.getId());
        dto.setAuthorId(book.getId());

        return dto;

    }

    public BookModel toEntity(BookDTO dto) {
        if (dto == null) {
            return null;
        }

        BookModel book = new BookModel();

        book.setName(dto.getName());
        book.setId(dto.getId());
        book.setId(dto.getAuthorId());

        return book;
    }

}
