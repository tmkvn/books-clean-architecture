package com.ucacue.api.infrastructure.adapters.output;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface BookEntityRepository extends JpaRepository<BookEntity, UUID> {
}
