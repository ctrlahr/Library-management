package com.jorge.library.Book;

import com.jorge.library.Author.AuthorDTO;
import com.jorge.library.Author.AuthorModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import org.antlr.v4.runtime.misc.NotNull;
import org.apache.logging.log4j.message.Message;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookDTO {

    private Long id;
    private String name;

    @NonNull
    private Long author_id;

}
