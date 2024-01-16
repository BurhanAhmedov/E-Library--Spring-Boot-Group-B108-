package az.divacademy.springbootb108.controller;

import az.divacademy.springbootb108.model.Book;
import az.divacademy.springbootb108.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/book")
@RequiredArgsConstructor
public class BookController {
  private final BookService bookService;

  @PostMapping()
  public ResponseEntity<Book> insertBook(@RequestBody Book book){
     Book response = bookService.insertBook(book);
    return ResponseEntity.ok(response);
  }

}
