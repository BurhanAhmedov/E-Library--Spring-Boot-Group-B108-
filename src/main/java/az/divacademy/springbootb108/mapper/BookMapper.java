package az.divacademy.springbootb108.mapper;

import az.divacademy.springbootb108.dto.BookDto;
import az.divacademy.springbootb108.model.Book;
import az.divacademy.springbootb108.request.BookRequest;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring",
    nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface BookMapper {

  BookDto mapToDtoFromBook(Book book);

  Book mapToBookFromRequest(BookRequest request);

  @Mapping(target = "id", ignore = true)
  @Mapping(target = "active", ignore = true)
  Book mapForUpdate(@MappingTarget Book book, BookRequest request);
}
