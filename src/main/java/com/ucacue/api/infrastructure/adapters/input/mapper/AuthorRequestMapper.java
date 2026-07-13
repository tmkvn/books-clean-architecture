package com.ucacue.api.infrastructure.adapters.input.mapper;

import com.ucacue.api.domain.model.Author;
import com.ucacue.api.infrastructure.adapters.input.dto.AuthorRequest;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface AuthorRequestMapper {

    AuthorRequestMapper INSTANCE = Mappers.getMapper(AuthorRequestMapper.class);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "books", ignore = true)
    Author toAuthor(AuthorRequest request);
}
