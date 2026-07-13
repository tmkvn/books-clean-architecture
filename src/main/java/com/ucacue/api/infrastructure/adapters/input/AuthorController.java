package com.ucacue.api.infrastructure.adapters.input;

import com.ucacue.api.application.ports.input.IAuthorUseCase;
import com.ucacue.api.domain.model.Author;
import com.ucacue.api.infrastructure.adapters.input.dto.AuthorRequest;
import com.ucacue.api.infrastructure.adapters.input.dto.AuthorResponse;
import com.ucacue.api.infrastructure.adapters.input.mapper.AuthorRequestMapper;
import com.ucacue.api.infrastructure.adapters.input.mapper.AuthorResponseMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/authors")
public class AuthorController {

    private final IAuthorUseCase authorUseCase;

    public AuthorController(IAuthorUseCase authorUseCase) {
        this.authorUseCase = authorUseCase;
    }

    @PostMapping
    public ResponseEntity<AuthorResponse> create(@RequestBody AuthorRequest request) {
        Author author = authorUseCase.create(AuthorRequestMapper.INSTANCE.toAuthor(request));
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(AuthorResponseMapper.INSTANCE.toResponse(author));
    }
}
