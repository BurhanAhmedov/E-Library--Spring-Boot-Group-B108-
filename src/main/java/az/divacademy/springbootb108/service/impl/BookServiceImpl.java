package az.divacademy.springbootb108.service.impl;

import az.divacademy.springbootb108.dto.BookDto;
import az.divacademy.springbootb108.exception.NoDataFoundException;
import az.divacademy.springbootb108.mapper.BookMapper;
import az.divacademy.springbootb108.model.Author;
import az.divacademy.springbootb108.model.Book;
import az.divacademy.springbootb108.repository.AuthorRepository;
import az.divacademy.springbootb108.repository.BookRepository;
import az.divacademy.springbootb108.request.BookRequest;
import az.divacademy.springbootb108.service.BookService;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
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
  private final AuthorRepository authorRepository;
  private final BookMapper bookMapper;
 //private final BookBatis bookBatis;


  @Override
  public BookDto insertBook(BookRequest request) {
    final List<Author> authors =  authorRepository.findAllById(request.getAuthorIds());
    final Book book = bookMapper.mapToBookFromRequest(request);
    if (!authors.isEmpty() && authors!=null){
      final Set<Author> authorSet = new HashSet<>(authors);
      book.setAuthors(authorSet);
      Book savedBook = bookRepository.save(book);
      log.info("Book insert success!");
      final BookDto bookDto = bookMapper.mapToDtoFromBook(savedBook);
      log.info("Book mapper success");
      return bookDto;
    }else {
      throw new NoDataFoundException("Authors Not Found");
    }


  }

  @Override
  public BookDto findBookById(long id) {
    final Book book = bookRepository
        .findById(id)
        .orElseThrow(() -> new NoDataFoundException("Book Not Found " + id));

    final BookDto bookDto = bookMapper.mapToDtoFromBook(book);
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
