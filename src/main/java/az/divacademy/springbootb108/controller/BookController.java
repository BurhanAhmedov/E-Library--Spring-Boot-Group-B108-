package az.divacademy.springbootb108.controller;

import az.divacademy.springbootb108.dto.BookDto;
import az.divacademy.springbootb108.model.Book;
import az.divacademy.springbootb108.request.BookRequest;
import az.divacademy.springbootb108.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/book")
@RequiredArgsConstructor
public class BookController {
  private final BookService bookService;

  @PostMapping()
  public ResponseEntity<BookDto> insertBook(@RequestBody BookRequest request){
     BookDto response = bookService.insertBook(request);
    return ResponseEntity.ok(response);
  }

  @GetMapping("{id}")
  public ResponseEntity<BookDto> findBookById(@PathVariable long id){
    final BookDto response = bookService.findBookById(id);
    return ResponseEntity.ok(response);

  }

}
