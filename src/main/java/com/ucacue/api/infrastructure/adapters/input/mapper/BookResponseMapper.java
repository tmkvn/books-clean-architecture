package com.ucacue.api.infrastructure.adapters.input.mapper;

import com.ucacue.api.domain.model.Book;
import com.ucacue.api.infrastructure.adapters.input.dto.BookResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface BookResponseMapper {

    BookResponseMapper INSTANCE = Mappers.getMapper(BookResponseMapper.class);

    @Mapping(target = "authorId", source = "author.id")
    BookResponse toResponse(Book book);
}
