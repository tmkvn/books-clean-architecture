package com.ucacue.api.infrastructure.adapters.output;

import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class BookEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String title;
    @ManyToOne
    @JoinColumn(name = "author_id")
    private AuthorEntity author;
    @Column(name = "publication_year")
    private Integer year;
}
