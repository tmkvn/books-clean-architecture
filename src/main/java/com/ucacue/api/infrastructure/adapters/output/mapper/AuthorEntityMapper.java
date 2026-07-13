package com.ucacue.api.infrastructure.adapters.output.mapper;

import com.ucacue.api.domain.model.Author;
import com.ucacue.api.infrastructure.adapters.output.AuthorEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface AuthorEntityMapper {

    AuthorEntityMapper INSTANCE = Mappers.getMapper(AuthorEntityMapper.class);

    @Mapping(target = "books", ignore = true)
    AuthorEntity toEntity(Author author);

    @Mapping(target = "books", ignore = true)
    Author toAuthor(AuthorEntity authorEntity);
}
