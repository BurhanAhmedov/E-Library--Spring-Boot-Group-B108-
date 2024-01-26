package az.divacademy.springbootb108.service;

import az.divacademy.springbootb108.dto.AuthorDto;
import az.divacademy.springbootb108.request.AuthorRequest;
import java.util.List;

public interface AuthorService {

  AuthorDto insertAuthor(AuthorRequest request);

  AuthorDto findAuthorById(long id);

  List<AuthorDto> findByNameAndSurname(String name, String surname);

  List<AuthorDto> findAll();

  AuthorDto updateAuthor(long id, AuthorRequest request);

  void softDeleteAuthorById(long id);
}
