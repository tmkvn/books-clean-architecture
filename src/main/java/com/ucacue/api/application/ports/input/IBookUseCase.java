package com.ucacue.api.application.ports.input;

import com.ucacue.api.domain.model.Book;

import java.util.List;
import java.util.UUID;

public interface IBookUseCase {

    Book create(Book book);

    List<Book> findByAuthorIdAndYear(UUID authorId, Integer year);
}
