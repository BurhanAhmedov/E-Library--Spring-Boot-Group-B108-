package az.divacademy.springbootb108.service;

import az.divacademy.springbootb108.dto.BookDto;
import az.divacademy.springbootb108.exception.NoDataFoundException;
import az.divacademy.springbootb108.mapper.BookMapper;
import az.divacademy.springbootb108.model.Book;
import az.divacademy.springbootb108.repository.BookRepository;
import az.divacademy.springbootb108.request.BookRequest;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Slf4j
@RequiredArgsConstructor
@Transactional
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
  System.out.println();
    final BookDto bookDto = bookRepository
        .findById(id)
        .map(bookMapper::mapToDtoFromBook)
        .orElseThrow(() -> new NoDataFoundException("Book Not Found " + id));
    return bookDto;
  }

  @Override
  public List<BookDto> findByName(String name) {
    List<BookDto> dtoList = null;
    try {
      final List<Book> bookList = bookRepository.findByNameAndActiveTrue(name);
      dtoList = bookList.stream()
          .map(bookMapper::mapToDtoFromBook)
          .collect(Collectors.toList());
    } catch (Exception e) {
      log.error("Book Not Found By Name:" + name);
      e.getMessage();
    }
    return dtoList;
  }

  @Override
  public List<BookDto> findAll() {
    final List<Book> all = bookRepository.findAll();

    return all.stream()
        .map(bookMapper::mapToDtoFromBook)
        .collect(Collectors.toList());

  }

  @Override
  public BookDto updateBook(long id, BookRequest request) {

    final Book book = bookRepository.findById(id)
        .orElseThrow(() -> new NoDataFoundException("Book Not Found By Id:" + id));
    final Book newBook = bookMapper.mapForUpdate(book, request);

    final Book savedBook = bookRepository.save(newBook);
    return bookMapper.mapToDtoFromBook(savedBook);

  }

  @Override
  public void softDeleteBookById(long id) {
    bookRepository.softDeleteBookById(id);
  }
}
