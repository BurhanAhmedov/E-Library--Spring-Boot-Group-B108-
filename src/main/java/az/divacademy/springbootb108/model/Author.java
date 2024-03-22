package az.divacademy.springbootb108.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import java.util.Set;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@EqualsAndHashCode(of = "id")
public class Author {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  long id;
  @Size(min = 1,max = 5,message = "")
  String name;
  String surname;
  boolean active;
  @ManyToMany(mappedBy = "authors")
  Set<Book> books;
 // @Size(min = 1,max = 8)
  @NotNull
  int a;

}
