package com.example.Library.Management.System.Controller;

import com.example.Library.Management.System.DTO.BookDTO;
import com.example.Library.Management.System.Entitiy.Book;
import com.example.Library.Management.System.Services.BookServices;
import lombok.Data;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("Library")

public class BookController {
    @Autowired
    private BookServices bookServices;
    @PostMapping("/SaveBook")
    public ResponseEntity<Book> saveBook(@RequestBody Book book){
            return new ResponseEntity<Book>(bookServices.listOfBook(book), HttpStatus.CREATED);
    }

    @GetMapping("/GetBook")
        public List<BookDTO> getAllBook(){
        List<Book> theBooks=bookServices.getAllBooks();
        return theBooks.stream().map(this::convertToDto).collect(Collectors.toList());
    }
    @GetMapping("/search")
    public List<Book> getBookByName(Model model, @Param("search") String keyword){
        List<Book> bookList=bookServices.getBookByName(keyword);
        model.addAttribute("listOfBook",bookList);
        model.addAttribute("keyword",keyword);
        return bookList;
    }
        @PutMapping("updateBook/{id}")
        public ResponseEntity<Book> updateBook(@PathVariable("id") long id,@RequestBody Book book){
            return new ResponseEntity<Book>(bookServices.updateBook(book,id),HttpStatus.OK);
        }
        @DeleteMapping("DeleteBook/{id}")
        public ResponseEntity<String> deleteBook(@PathVariable("id")long id){
            String book=bookServices.deleteBook(id);
            return new ResponseEntity<String>("Book " +book  +" deleted Sucessfully!",HttpStatus.OK);
        }
    @Autowired
    private ModelMapper modelMapper;
    private BookDTO convertToDto(Book book) {
        BookDTO bookDTO = modelMapper.map(book, BookDTO.class);
        return bookDTO;
    }

}
