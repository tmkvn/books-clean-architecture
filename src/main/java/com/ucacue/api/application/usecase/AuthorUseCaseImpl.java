package com.ucacue.api.application.usecase;

import com.ucacue.api.application.ports.input.IAuthorUseCase;
import com.ucacue.api.application.ports.output.AuthorPort;
import com.ucacue.api.domain.model.Author;
import org.springframework.stereotype.Service;

@Service
public class AuthorUseCaseImpl implements IAuthorUseCase {

    private final AuthorPort authorPort;

    public AuthorUseCaseImpl(AuthorPort authorPort) {
        this.authorPort = authorPort;
    }

    @Override
    public Author create(Author author) {
        return authorPort.create(author);
    }
}
