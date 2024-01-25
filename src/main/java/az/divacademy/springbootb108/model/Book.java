package az.divacademy.springbootb108.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import java.time.LocalDate;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.data.annotation.CreatedDate;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Book {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  long id;
  String name;
  Integer pageCount;
  Integer price;
  Integer stock;
  boolean active;

  @CreatedDate
  LocalDate createDate;

}
