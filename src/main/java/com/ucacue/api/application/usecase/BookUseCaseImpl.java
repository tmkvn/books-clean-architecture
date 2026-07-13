package com.ucacue.api.application.usecase;

import com.ucacue.api.application.ports.input.IBookUseCase;
import com.ucacue.api.application.ports.output.AuthorPort;
import com.ucacue.api.application.ports.output.BookPort;
import com.ucacue.api.domain.model.Author;
import com.ucacue.api.domain.model.Book;
import com.ucacue.api.domain.service.BookService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class BookUseCaseImpl implements IBookUseCase {

    private final BookPort bookPort;
    private final AuthorPort authorPort;

    public BookUseCaseImpl(BookPort bookPort, AuthorPort authorPort) {
        this.bookPort = bookPort;
        this.authorPort = authorPort;
    }

    @Override
    public Book create(Book book) {
        UUID authorId = book.getAuthor() == null ? null : book.getAuthor().getId();
        if (authorId == null) {
            throw new IllegalArgumentException("authorId is required");
        }
        Author author = authorPort.findById(authorId);
        if (author == null) {
            throw new IllegalArgumentException("Author not found: " + authorId);
        }
        book.setAuthor(author);
        return bookPort.create(book);
    }

    @Override
    public List<Book> findByAuthorIdAndYear(UUID authorId, Integer year) {
        return BookService.filterByAuthorIdAndYear(bookPort.findAll(), authorId, year);
    }
}
