package az.divacademy.springbootb108.repository;

import az.divacademy.springbootb108.dto.BookDto;
import az.divacademy.springbootb108.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface BookRepository extends JpaRepository<Book,Long> {
  @Query(value = "",nativeQuery = true)
  BookDto findByNameAndActiveTrue(String name);

}
