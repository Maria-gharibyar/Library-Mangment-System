package com.example.Library.Management.System.Entitiy;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    //@Column(name = "categoryId",nullable = false)
    private Long categoryId;
    private String categoryName;
    @ManyToMany(mappedBy = "categoryList")
    private List<Book> bookList;

}
