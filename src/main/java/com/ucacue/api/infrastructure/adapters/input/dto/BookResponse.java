package com.ucacue.api.infrastructure.adapters.input.dto;

import java.util.UUID;

public record BookResponse(String title, UUID authorId, Integer year) {
}
