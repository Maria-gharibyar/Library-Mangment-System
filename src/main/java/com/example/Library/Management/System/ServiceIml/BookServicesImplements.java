package com.example.Library.Management.System.ServiceIml;

import com.example.Library.Management.System.Entitiy.Book;
import com.example.Library.Management.System.Exception.NotFoundException;
import com.example.Library.Management.System.Services.BookServices;
import com.example.Library.Management.System.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookServicesImplements implements BookServices {
    @Autowired
    private BookRepository bookRepository;
    @Override
    public Book listOfBook(Book book) {
        return bookRepository.save(book);
    }

    @Override
    public List<Book> getAllBooks() {
        List<Book> theBooks=bookRepository.findAll();
        return theBooks;
    }

    @Override
    public List<Book> getBookByName(String keyword) {
        List<Book> book=bookRepository.getBookByName(keyword);
        return book;
    }

    @Override
    public Book updateBook(Book book,long id) {
        Book ExistBook=bookRepository.findById(id).orElseThrow(
                ()->new NotFoundException("Book","id",id)
        );
        ExistBook.setName(book.getName());
        ExistBook.setCategoryList(book.getCategoryList());
        bookRepository.save(ExistBook);
        return ExistBook;
    }

    @Override
    public String deleteBook(long id) {
        String name = bookRepository.getById(id).getName();
        bookRepository.findById(id).orElseThrow(
                ()->new NotFoundException("Book","id",id)
        );
        bookRepository.deleteById(id);
        return name;
    }


}
