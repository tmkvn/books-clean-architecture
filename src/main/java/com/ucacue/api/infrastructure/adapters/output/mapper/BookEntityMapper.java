package com.ucacue.api.infrastructure.adapters.output.mapper;

import com.ucacue.api.domain.model.Book;
import com.ucacue.api.infrastructure.adapters.output.BookEntity;
import org.mapstruct.Mapping;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface BookEntityMapper {

    BookEntityMapper INSTANCE = Mappers.getMapper(BookEntityMapper.class);

    @Mapping(target = "author", ignore = true)
    @Mapping(target = "id", ignore = true)
    BookEntity toEntity(Book book);

    @Mapping(target = "author.books", ignore = true)
    Book toBook(BookEntity bookEntity);
}
