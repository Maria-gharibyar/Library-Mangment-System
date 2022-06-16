package com.example.Library.Management.System.DTO;

import com.example.Library.Management.System.Entitiy.Category;
import com.example.Library.Management.System.Entitiy.Library;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;
@Getter
@Setter
public class BookDto2 {
    private Long bookId;
    private String name;
    private LocalDate IssuedDate;
    private LocalDate ReturnDate;
    private Library library;
    private List<Category> categoryList;
}
