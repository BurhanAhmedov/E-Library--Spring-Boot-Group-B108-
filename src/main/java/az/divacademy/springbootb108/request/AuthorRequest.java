package az.divacademy.springbootb108.request;

import az.divacademy.springbootb108.model.Book;
import java.util.Set;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class AuthorRequest {

  long id;
  String name;
  String surname;
  boolean active;
}
