package com.ucacue.api.infrastructure.adapters.output;

import com.ucacue.api.application.ports.output.AuthorPort;
import com.ucacue.api.domain.model.Author;
import com.ucacue.api.infrastructure.adapters.output.mapper.AuthorEntityMapper;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class AuthorAdapter implements AuthorPort {

    private final AuthorEntityRepository repository;

    public AuthorAdapter(AuthorEntityRepository repository) {
        this.repository = repository;
    }

    @Override
    public Author create(Author author) {
        AuthorEntity entity = AuthorEntityMapper.INSTANCE.toEntity(author);
        return AuthorEntityMapper.INSTANCE.toAuthor(repository.save(entity));
    }

    @Override
    public Author findById(UUID id) {
        AuthorEntity entity = repository.findAuthorEntityById(id);
        return entity == null ? null : AuthorEntityMapper.INSTANCE.toAuthor(entity);
    }
}
