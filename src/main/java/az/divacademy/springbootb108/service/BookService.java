package az.divacademy.springbootb108.service;

import az.divacademy.springbootb108.dto.BookDto;
import az.divacademy.springbootb108.request.BookRequest;
import java.util.List;

public interface BookService {

  BookDto insertBook(BookRequest request);

  BookDto findBookById(long id);

  List<BookDto> findByName(String name);

  List<BookDto> findAll();

  BookDto updateBook(long id, BookRequest request);

  void softDeleteBookById(long id);
}
