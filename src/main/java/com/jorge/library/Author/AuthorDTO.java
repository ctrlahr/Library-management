package com.jorge.library.Author;

import com.jorge.library.Book.BookModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AuthorDTO {

    private Long id;
    private String name;
    private Integer age;
    private List<BookModel> books;

}
