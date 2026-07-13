package com.ucacue.api.application.ports.input;

import com.ucacue.api.domain.model.Author;

public interface IAuthorUseCase {

    Author create(Author author);
}
