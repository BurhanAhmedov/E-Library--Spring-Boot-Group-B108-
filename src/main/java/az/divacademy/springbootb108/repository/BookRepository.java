package az.divacademy.springbootb108.repository;

import az.divacademy.springbootb108.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book,Long> {

}
