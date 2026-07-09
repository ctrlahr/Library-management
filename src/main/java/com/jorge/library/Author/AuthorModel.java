package com.jorge.library.Author;

import com.jorge.library.Book.BookModel;
import com.jorge.library.roles.RolesModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Fetch;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "tb_author")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AuthorModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private Long id;

    @Column(name = "Name")
    private String name;

    @Column(name = "Age")
    private int age;

    @Column(name = "Books")
    @OneToMany(mappedBy = "author", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<BookModel> books;

    private String password;


    // Liga A tabela de alunos com roles
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "AuthorRoles",
            joinColumns = @JoinColumn(name = "authorId"),
            inverseJoinColumns = @JoinColumn(name = "roleId"))
    private Set<RolesModel> roles = new HashSet<>();



}
