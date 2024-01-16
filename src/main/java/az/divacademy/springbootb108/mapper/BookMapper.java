package az.divacademy.springbootb108.mapper;

import az.divacademy.springbootb108.dto.BookDto;
import az.divacademy.springbootb108.model.Book;
import az.divacademy.springbootb108.request.BookRequest;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface BookMapper {

  BookDto mapToDtoFromBook(Book book);

  Book mapToBookFromRequest(BookRequest request);

}
