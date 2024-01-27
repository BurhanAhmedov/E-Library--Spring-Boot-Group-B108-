package az.divacademy.springbootb108.controller;

import az.divacademy.springbootb108.dto.AuthorDto;
import az.divacademy.springbootb108.service.AuthorService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/author")
@RequiredArgsConstructor
public class AuthorController {

  private final AuthorService service;

  @GetMapping("{id}")
  public ResponseEntity<AuthorDto> findAuthorById(@PathVariable long id) {
    final AuthorDto response = service.findAuthorById(id);
    return ResponseEntity.ok(response);
  }

  @GetMapping
  public ResponseEntity<List<AuthorDto>> findAuthorByNameAndSurname(@RequestParam String name, @RequestParam String surname){
    final List<AuthorDto> response = service.findByNameAndSurname(name, surname);
    return ResponseEntity.ok(response);
  }
}
