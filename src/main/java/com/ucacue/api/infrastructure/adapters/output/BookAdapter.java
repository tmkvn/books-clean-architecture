package com.ucacue.api.infrastructure.adapters.output;

import com.ucacue.api.application.ports.output.BookPort;
import com.ucacue.api.domain.model.Book;
import com.ucacue.api.infrastructure.adapters.output.mapper.BookEntityMapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class BookAdapter implements BookPort {

    private final BookEntityRepository repository;
    private final AuthorEntityRepository authorRepository;

    public BookAdapter(BookEntityRepository repository, AuthorEntityRepository authorRepository) {
        this.repository = repository;
        this.authorRepository = authorRepository;
    }

    @Override
    public Book create(Book book) {
        BookEntity entity = BookEntityMapper.INSTANCE.toEntity(book);
        entity.setAuthor(authorRepository.getReferenceById(book.getAuthor().getId()));
        return BookEntityMapper.INSTANCE.toBook(repository.save(entity));
    }

    @Override
    public List<Book> findAll() {
        return repository.findAll().stream()
                .map(BookEntityMapper.INSTANCE::toBook)
                .toList();
    }
}
