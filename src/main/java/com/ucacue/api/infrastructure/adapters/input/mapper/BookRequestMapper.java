package com.ucacue.api.infrastructure.adapters.input.mapper;

import com.ucacue.api.domain.model.Book;
import com.ucacue.api.infrastructure.adapters.input.dto.BookRequest;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface BookRequestMapper {

    BookRequestMapper INSTANCE = Mappers.getMapper(BookRequestMapper.class);

    @Mapping(target = "author", ignore = true)
    Book toBook(BookRequest request);
}
