package com.example.Library.Management.System.Entitiy;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.tomcat.jni.Local;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Book {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long bookId;
    private String name;
    @JsonFormat(pattern="yyyy-MM-dd")
    private LocalDate IssuedDate;
    @JsonFormat(pattern="yyyy-MM-dd")
    private LocalDate ReturnDate;

    @ManyToOne
    @JoinColumn(name = "libraryID")
    private Library library;
    @ManyToOne
    @JoinColumn(name = "studentId")
    private Student student;
    @ManyToOne
    @JoinColumn(name = "teacherId")
    private Teacher teacher;
    @ManyToMany
    @JoinTable(name = "book_categories",joinColumns=@JoinColumn(name="bookId"),inverseJoinColumns = @JoinColumn(name="categoryId"))
    private List<Category> categoryList;

}
