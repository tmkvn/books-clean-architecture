package com.ucacue.api.application.ports.output;

import com.ucacue.api.domain.model.Author;

import java.util.UUID;

public interface AuthorPort {

    Author create(Author author);

    Author findById(UUID id);
}
