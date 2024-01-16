package az.divacademy.springbootb108.service;

import az.divacademy.springbootb108.dto.BookDto;
import az.divacademy.springbootb108.request.BookRequest;

public interface BookService {

  BookDto insertBook(BookRequest request);

  BookDto findBookById(long id);

}
