package az.divacademy.springbootb108.request;

import jakarta.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.List;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class BookRequest {

  long id;
  @NotNull
  String name;
  Integer pageCount;
  Integer price;
  Integer stock;
  boolean active;
  LocalDate createDate;
  List<Long> authorIds;

}
