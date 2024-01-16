package az.divacademy.springbootb108.service;

import az.divacademy.springbootb108.dto.BookDto;
import az.divacademy.springbootb108.mapper.BookMapper;
import az.divacademy.springbootb108.model.Book;
import az.divacademy.springbootb108.repository.BookRepository;
import az.divacademy.springbootb108.request.BookRequest;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {

  private final BookRepository bookRepository;
  private final BookMapper bookMapper;


  @Override
  public BookDto insertBook(BookRequest request) {
    final Book book = bookMapper.mapToBookFromRequest(request);
    Book savedBook = bookRepository.save(book);
    log.info("Book insert success!");
    final BookDto bookDto = bookMapper.mapToDtoFromBook(savedBook);
    log.info("Book mapper success");
    return bookDto;
  }

  @Override
  public BookDto findBookById(long id) {
    final Optional<Book> findingBook =
        Optional.ofNullable(bookRepository
            .findById(id)
            .orElseThrow(() -> new RuntimeException()));
    Book book = findingBook.get();
    final BookDto bookDto = bookMapper.mapToDtoFromBook(book);

    return bookDto;
  }
}
