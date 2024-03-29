package az.divacademy.springbootb108.mapper;

import az.divacademy.springbootb108.dto.AuthorDto;
import az.divacademy.springbootb108.model.Author;
import az.divacademy.springbootb108.request.AuthorRequest;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring",
    nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface AuthorMapper {

  AuthorDto mapToDtoFromAuthor(Author author);

  Author mapToAuthorFromRequest(AuthorRequest request);

  @Mapping(target = "id", ignore = true)
  @Mapping(target = "active", ignore = true)
  Author mapForUpdate(@MappingTarget Author author, AuthorRequest request);
}
