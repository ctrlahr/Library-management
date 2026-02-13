package com.jorge.library.Author;

import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class AuthorMapper {

    public AuthorDTO toDTO(AuthorModel author) {
        if (author == null) {
            return null;
        }

        AuthorDTO dto = new AuthorDTO();

        dto.setId(author.getId());
        dto.setAge(author.getAge());
        dto.setName(author.getName());
        dto.setBooks(author.getBooks());

        return dto;

    }

    public AuthorModel toEntity(AuthorDTO dto) {

        if (dto == null) {
            return null;
        }

        AuthorModel author = new AuthorModel();

        author.setId(dto.getId());
        author.setAge(dto.getAge());
        author.setName(dto.getName());
        author.setBooks(dto.getBooks());

        return author;
    }

    public List<AuthorDTO> toDTOList(List<AuthorModel> author) {

        return author.stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

}
