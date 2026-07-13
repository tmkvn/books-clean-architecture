package com.ucacue.api.infrastructure.adapters.input.dto;

import java.util.UUID;

public record AuthorResponse(UUID id, String firstName, String lastName) {
}
