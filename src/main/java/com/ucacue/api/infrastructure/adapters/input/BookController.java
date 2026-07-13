package com.ucacue.api.infrastructure.adapters.input;

import com.ucacue.api.application.ports.input.IBookUseCase;
import com.ucacue.api.domain.model.Author;
import com.ucacue.api.domain.model.Book;
import com.ucacue.api.infrastructure.adapters.input.dto.BookRequest;
import com.ucacue.api.infrastructure.adapters.input.dto.BookResponse;
import com.ucacue.api.infrastructure.adapters.input.mapper.BookRequestMapper;
import com.ucacue.api.infrastructure.adapters.input.mapper.BookResponseMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/v1/books")
public class BookController {

    private final IBookUseCase bookUseCase;

    public BookController(IBookUseCase bookUseCase) {
        this.bookUseCase = bookUseCase;
    }

    @PostMapping
    public ResponseEntity<BookResponse> create(@RequestBody BookRequest request) {
        Book book = BookRequestMapper.INSTANCE.toBook(request);
        book.setAuthor(new Author(request.authorId(), null, null, null));
        Book created = bookUseCase.create(book);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(BookResponseMapper.INSTANCE.toResponse(created));
    }

    @GetMapping
    public List<BookResponse> findByAuthorIdAndYear(
            @RequestParam UUID authorId,
            @RequestParam(name = "Year") Integer year) {
        return bookUseCase.findByAuthorIdAndYear(authorId, year).stream()
                .map(BookResponseMapper.INSTANCE::toResponse)
                .toList();
    }
}
