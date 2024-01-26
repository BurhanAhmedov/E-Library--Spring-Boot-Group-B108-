package az.divacademy.springbootb108.service.impl;

import az.divacademy.springbootb108.dto.AuthorDto;
import az.divacademy.springbootb108.exception.NoDataFoundException;
import az.divacademy.springbootb108.mapper.AuthorMapper;
import az.divacademy.springbootb108.model.Author;
import az.divacademy.springbootb108.repository.AuthorRepository;
import az.divacademy.springbootb108.request.AuthorRequest;
import az.divacademy.springbootb108.service.AuthorService;
import java.util.List;
import java.util.stream.Collectors;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AuthorServiceImpl implements AuthorService {

  private final AuthorRepository repository;
  private final AuthorMapper mapper;

  @Override
  public AuthorDto insertAuthor(AuthorRequest request) {
    final Author author = mapper.mapToAuthorFromRequest(request);
    repository.save(author);
    final AuthorDto authorDto = mapper.mapToDtoFromAuthor(author);
    return authorDto;
  }

  @Override
  public AuthorDto findAuthorById(long id) {
    final AuthorDto authorDto = repository.findById(id)
        .map(mapper::mapToDtoFromAuthor)
        .orElseThrow(() -> new NoDataFoundException("Author Not Found By Id: " + id));
    return authorDto;
  }

  public List<AuthorDto> findByNameAndSurname(String name, String surname) {
    final List<Author> authorList = repository.findByNameAndSurnameAndActiveTrue(name, surname);
    final List<AuthorDto> authorDtoList = authorList.stream()
        .map(mapper::mapToDtoFromAuthor)
        .collect(Collectors.toList());
    return authorDtoList;
  }

  @Override
  public List<AuthorDto> findAll() {
    final List<Author> authorList = repository.findAll();
    final List<AuthorDto> authorDtoList = authorList.stream()
        .map(mapper::mapToDtoFromAuthor)
        .collect(Collectors.toList());
    return authorDtoList;
  }

  @Override
  public AuthorDto updateAuthor(long id, AuthorRequest request) {
    return null;
  }

  @Override
  public void softDeleteAuthorById(long id) {

  }
}
