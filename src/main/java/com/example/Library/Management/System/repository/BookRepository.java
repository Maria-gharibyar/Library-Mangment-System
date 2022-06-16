package com.example.Library.Management.System.repository;

import com.example.Library.Management.System.Entitiy.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book,Long> {
    List<Book> getBookByName(String keyword);
}
