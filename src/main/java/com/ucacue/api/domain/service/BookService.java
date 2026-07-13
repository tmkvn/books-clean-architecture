package com.ucacue.api.domain.service;

import com.ucacue.api.domain.model.Book;

import java.util.List;
import java.util.UUID;

public final class BookService {

    private BookService() {
    }

    public static List<Book> filterByAuthorIdAndYear(List<Book> books, UUID authorId, Integer year) {
        return books.stream()
                .filter(book -> book.getAuthor() != null && authorId.equals(book.getAuthor().getId()))
                .filter(book -> year.equals(book.getYear()))
                .toList();
    }
}
