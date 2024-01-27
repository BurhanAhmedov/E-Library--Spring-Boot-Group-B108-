package az.divacademy.springbootb108.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.data.annotation.CreatedDate;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
@EqualsAndHashCode(of = "id")
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

  @ManyToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
      @JoinTable(name = "book_author",
      joinColumns = @JoinColumn(name = "book_id"),
      inverseJoinColumns = @JoinColumn(name = "author_id"))
  Set<Author> authors = new HashSet<>();

}
