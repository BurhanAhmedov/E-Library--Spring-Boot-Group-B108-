package az.divacademy.springbootb108.controller;

import az.divacademy.springbootb108.dto.BookDto;
import az.divacademy.springbootb108.request.BookRequest;
import az.divacademy.springbootb108.service.BookService;
import jakarta.validation.Valid;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/book")
@RequiredArgsConstructor
public class BookController {

  private final BookService bookService;

  @PostMapping()
  @PreAuthorize("hasAuthority('Admin')")
  public ResponseEntity<BookDto> insertBook(@Valid @RequestBody BookRequest request) {
    BookDto response = bookService.insertBook(request);
    return ResponseEntity.ok(response);
  }

  @GetMapping("{id}")
  public ResponseEntity<BookDto> findBookById(@PathVariable long id) {
    final BookDto response = bookService.findBookById(id);
    return ResponseEntity.ok(response);
  }

  @GetMapping("name/{name}")
  public ResponseEntity<List<BookDto>> findBookByName(@PathVariable String name) {
    final List<BookDto> response = bookService.findByName(name);
    return ResponseEntity.ok(response);
  }

  @GetMapping("all")
  public ResponseEntity<List<BookDto>> findAllBooks() {
    final List<BookDto> all = bookService.findAll();
    return ResponseEntity.ok(all);

  }

  @PutMapping("{id}")
  public ResponseEntity<BookDto> updateBook(@RequestBody BookRequest request,
      @PathVariable long id) {
    final BookDto bookDto = bookService.updateBook(id, request);
    return ResponseEntity.ok(bookDto);
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<HttpStatus> deleteBookById(@PathVariable long id) {
    bookService.softDeleteBookById(id);
    return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
  }
}
