package az.divacademy.springbootb108.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.Set;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@AllArgsConstructor
@NoArgsConstructor
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class AuthorDto {

  String name;
  String surname;

}
