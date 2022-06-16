package com.example.Library.Management.System.DTO;

import com.example.Library.Management.System.Entitiy.Category;
import com.example.Library.Management.System.Entitiy.Library;
import com.example.Library.Management.System.Entitiy.Student;
import com.example.Library.Management.System.Entitiy.Teacher;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import java.time.LocalDate;
import java.util.List;

@Setter
@Getter
public class BookDTO {
    private Long bookId;
    private String name;
    private LocalDate IssuedDate;
    private LocalDate ReturnDate;
    private Library library;
    private Student student;
    private Teacher teacher;
    private List<Category> categoryList;

}
