package com.ucacue.api.infrastructure.adapters.input.mapper;

import com.ucacue.api.domain.model.Author;
import com.ucacue.api.infrastructure.adapters.input.dto.AuthorResponse;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface AuthorResponseMapper {

    AuthorResponseMapper INSTANCE = Mappers.getMapper(AuthorResponseMapper.class);

    AuthorResponse toResponse(Author author);
}
