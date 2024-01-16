package az.divacademy.springbootb108.service;

import az.divacademy.springbootb108.model.Book;
import az.divacademy.springbootb108.repository.BookRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class BookServiceImpl implements BookService {

  @Autowired
  private final BookRepository bookRepository;

  public BookServiceImpl(BookRepository bookRepository) {
    this.bookRepository = bookRepository;
  }

  @Override
  public Book insertBook(Book book) {
    Book savedBook = bookRepository.save(book);
    log.info("Book insert success!");
    return savedBook;
  }
}
