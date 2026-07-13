package com.ucacue.api.application.ports.output;

import com.ucacue.api.domain.model.Book;

import java.util.List;

public interface BookPort {

    Book create(Book book);

    List<Book> findAll();
}
