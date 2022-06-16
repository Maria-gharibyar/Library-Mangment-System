package com.example.Library.Management.System.Services;

import com.example.Library.Management.System.Entitiy.Book;

import java.util.List;

public interface BookServices {
   Book listOfBook(Book book);
   List<Book> getAllBooks();
   List<Book> getBookByName(String keyword);
   Book updateBook(Book book,long id);
   String deleteBook(long id);

}
